package com.digitalinnovationone.live.repository;


import com.digitalinnovationone.live.model.AccessLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> {
}
