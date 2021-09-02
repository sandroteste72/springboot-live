package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.AccessLevel;
import com.digitalinnovationone.live.service.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/access-level")
public class AccessLevelController {

    @Autowired
    AccessLevelService accessLevelService;

    @PostMapping
    public AccessLevel createAccessLevel (@RequestBody AccessLevel accessLevel) {
        return accessLevelService.save(accessLevel);
    }

    @GetMapping
    public List<AccessLevel> getAccessLevelList () {
        return accessLevelService.findAll();
    }

    @GetMapping("/{accessLevelId}")
    public ResponseEntity<AccessLevel> getAccessLevelByID(@PathVariable("accessLevelId") Long accessLevelId) throws Exception {
        return  ResponseEntity.ok(accessLevelService.findById(accessLevelId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public AccessLevel updateAccessLevel(@RequestBody AccessLevel accessLevel){
        return accessLevelService.updateAccessLevel(accessLevel);
    }

    @DeleteMapping(value = "/{accessLevelId}")
    public ResponseEntity<AccessLevel> deleteById(@PathVariable Long accessLevelId){
        accessLevelService.deleteAccessLevel(accessLevelId);
        return ResponseEntity.noContent().build();
    }
}
