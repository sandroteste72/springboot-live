package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.Movement;
import com.digitalinnovationone.live.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    MovementService movementService;

    @PostMapping
    public Movement createMovement (@RequestBody Movement movement) {
        return movementService.save(movement);
    }

    @GetMapping
    public List<Movement> getMovementList () {
        return movementService.findAll();
    }

    @GetMapping("/{movementId}")
    public ResponseEntity<Movement> getMovementById (@PathVariable Long movementId) throws Exception {
        return ResponseEntity.ok(movementService.findById(movementId).orElseThrow (() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Movement updateMovement (@RequestBody Movement movement) {
        return movementService.save(movement);
    }

    @DeleteMapping(value = "/{movementId}")
    public ResponseEntity<Movement> deleteById (@PathVariable Long movementId) {
        movementService.deleteMovement(movementId);
        return ResponseEntity.noContent().build();
    }
}
