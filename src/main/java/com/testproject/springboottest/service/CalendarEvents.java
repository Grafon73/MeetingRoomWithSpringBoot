package com.testproject.springboottest.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalendarEvents {
    ArrayList<String> eventByHour = new ArrayList<>();

        public Map<Integer,ArrayList<String>> getData(){
        for (int i=0;i<8;i++){
            eventByHour.add("");
        }
        Map<Integer,ArrayList<String>> mapOfEvents = new HashMap<>();
        for(int i = 1; i<25; i++){
            mapOfEvents.put(i,eventByHour);
        }
        return mapOfEvents;
    }


}