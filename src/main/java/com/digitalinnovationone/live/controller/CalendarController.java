package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.Calendar;
import com.digitalinnovationone.live.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @PostMapping
    public Calendar createCalendar (@RequestBody Calendar calendar) {
        return calendarService.save(calendar);
    }

    @GetMapping
    public List<Calendar> getCalendarList () {
        return calendarService.findAll();
    }

    @GetMapping("/{calendarId}")
    public ResponseEntity<Calendar> getCalendarByID(@PathVariable("calendarId") Long calendarId) throws Exception {
        return  ResponseEntity.ok(calendarService.findById(calendarId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Calendar updateCalendar(@RequestBody Calendar calendar){
        return calendarService.updateCalendar(calendar);
    }

    @DeleteMapping(value = "/{calendarId}")
    public ResponseEntity<Calendar> deleteById(@PathVariable Long calendarId){
        calendarService.deleteCalendar(calendarId);
        return ResponseEntity.noContent().build();
    }
}
