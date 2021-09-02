package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.Calendar;
import com.digitalinnovationone.live.model.Company;
import com.digitalinnovationone.live.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar save (Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    public Optional<Calendar> findById(Long calendarId) {
        return calendarRepository.findById(calendarId);
    }

    public Calendar updateCalendar(Calendar calendar){
        return calendarRepository.save(calendar);
    }

    public void deleteCalendar(Long calendarId) {
        calendarRepository.deleteById(calendarId);
    }
}
