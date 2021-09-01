package com.digitalinnovationone.live.repository;


import com.digitalinnovationone.live.model.WorkJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends JpaRepository<WorkJourney, Long> {
}
