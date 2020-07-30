package com.testproject.springboottest.controller;

import com.testproject.springboottest.model.Event;
import com.testproject.springboottest.repos.EventRepo;
import com.testproject.springboottest.service.CalendarEvents;
import com.testproject.springboottest.service.CalendarHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Controller
public class EventController {
    private final EventRepo eventRepo;
    private final CalendarHeader calendarHeader;
    private final CalendarEvents calendarEvents;

    @Autowired
    public EventController(EventRepo eventRepo, CalendarHeader calendarHeader, CalendarEvents calendarEvents) {
        this.eventRepo = eventRepo;
        this.calendarHeader = calendarHeader;
        this.calendarEvents = calendarEvents;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String mainPage(@RequestParam(value = "date", required = false) String name, Model model) {
        String[] header = new String[7];
        if(name==null||name.isEmpty()){
            header=calendarHeader.getColumnNames(new Date());
        }else{
            try {
                header = calendarHeader.getColumnNames(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(name));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Map<Integer, ArrayList<String>> data = calendarEvents.getData();
        Iterable<Event> events = eventRepo.findAll();
        model.addAttribute("header", header);
        model.addAttribute("daydata", data);
        model.addAttribute("events", events);
        return "index";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") int id,Model model) {
        Event event = eventRepo.findById(id).get();
        model.addAttribute("event", event);
        return "editEvent";
    }
    @PostMapping(value = "/edit")
    public String editPage(@ModelAttribute("event") Event event) {
       eventRepo.save(event);
        return "redirect:/";
    }


    @GetMapping(value = "/add")
    public String addPage(@RequestParam(value = "date", required = false) String date,
                          @RequestParam(value = "hour", required = false) String hour,
                          Model model) {
        model.addAttribute("date",date);
        model.addAttribute("hour",hour);
        return "addEvent";
    }

    @PostMapping(value = "/add")
    public String addPage(@ModelAttribute("event") Event event) {
        eventRepo.save(event);
        return "redirect:/";
    }


    @GetMapping(value = "/delete/{id}")
    public String addPage(@PathVariable("id") int id) {
        Event event = eventRepo.findById(id).get();
        eventRepo.delete(event);
        return "redirect:/";
    }
}