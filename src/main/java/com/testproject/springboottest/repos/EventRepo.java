package com.testproject.springboottest.repos;

import com.testproject.springboottest.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, Integer> {
}
