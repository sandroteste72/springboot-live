package com.digitalinnovationone.live.repository;


import com.digitalinnovationone.live.model.TypeDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDateRepository extends JpaRepository<TypeDate, Long> {
}
