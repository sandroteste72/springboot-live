package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.WorkJourney;
import com.digitalinnovationone.live.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/journey")
public class WorkJourneyController {

    @Autowired
    JourneyService journeyService;

    @PostMapping
    public WorkJourney createJourney (@RequestBody WorkJourney workJourney) {
        return journeyService.save(workJourney);
    }

    @GetMapping
    public List<WorkJourney> getJourneyList () {
        return journeyService.findAll();
    }

    @GetMapping("/{journeyId}")
    public ResponseEntity<WorkJourney> getJourneyByID(@PathVariable("journeyId") Long journeyId) throws Exception {
        return  ResponseEntity.ok(journeyService.findById(journeyId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public WorkJourney updateJourney(@RequestBody WorkJourney workJourney){
        return journeyService.updateJourney(workJourney);
    }

    @DeleteMapping("/{idJourney}")
    public ResponseEntity deleteByID(@PathVariable("idJourney") Long journeyId) throws Exception {
        try {
            journeyService.deleteJourney(journeyId);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<WorkJourney>) ResponseEntity.ok();
    }
}
