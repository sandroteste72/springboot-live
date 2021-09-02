package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.Movement;
import com.digitalinnovationone.live.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {

    @Autowired
    MovementRepository movementRepository;

    public Movement save(Movement movement){
        return movementRepository.save(movement);
    }

    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    public Optional<Movement> findById (Long movementId) {
        return movementRepository.findById(movementId);
    }

    public Movement updateMovement (Movement movement) {
        return movementRepository.save(movement);
    }

    public void deleteMovement (Long movementId) {
        movementRepository.deleteById(movementId);
    }
}
