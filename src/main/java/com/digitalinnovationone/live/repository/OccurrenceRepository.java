package com.digitalinnovationone.live.repository;


import com.digitalinnovationone.live.model.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {
}
