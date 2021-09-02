package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.Occurrence;
import com.digitalinnovationone.live.service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController {

    @Autowired
    OccurrenceService occurrenceService;

    @PostMapping
    public Occurrence createOccurrence (@RequestBody Occurrence occurrence) {
        return occurrenceService.save(occurrence);
    }

    @GetMapping
    public List<Occurrence> getCompanyList () {
        return occurrenceService.findAll();
    }

    @GetMapping("/{occurrenceId}")
    public ResponseEntity<Occurrence> getOccurrenceByID(@PathVariable("occurrenceId") Long occurrenceId) throws Exception {
        return  ResponseEntity.ok(occurrenceService.findById(occurrenceId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Occurrence updateOccurrence(@RequestBody Occurrence occurrence){
        return occurrenceService.updateOccurrence(occurrence);
    }

    @DeleteMapping(value = "/{occurrenceId}")
    public ResponseEntity<Occurrence> deleteById(@PathVariable Long occurrenceId){
        occurrenceService.deleteOccurrence(occurrenceId);
        return ResponseEntity.noContent().build();
    }
}
