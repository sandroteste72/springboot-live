package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.WorkJourney;
import com.digitalinnovationone.live.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JourneyService {

    JourneyRepository journeyRepository;

    @Autowired
    public JourneyService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    public WorkJourney save (WorkJourney workJourney) {
        return journeyRepository.save(workJourney);
    }

    public List<WorkJourney> findAll() {
        return journeyRepository.findAll();
    }

    public Optional<WorkJourney> findById(Long journeyId) {
        return journeyRepository.findById(journeyId);
    }

    public WorkJourney updateJourney(WorkJourney workJourney){
        return journeyRepository.save(workJourney);
    }

    public void deleteJourney(Long journeyId) {
        journeyRepository.deleteById(journeyId);
    }
}
