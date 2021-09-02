package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.Company;
import com.digitalinnovationone.live.model.TypeDate;
import com.digitalinnovationone.live.model.WorkJourney;
import com.digitalinnovationone.live.service.CompanyService;
import com.digitalinnovationone.live.service.TypeDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/type-date")
public class TypeDateController {

    @Autowired
    TypeDateService typeDateService;

    @PostMapping
    public TypeDate createTypeDate (@RequestBody TypeDate typeDate) {
        return typeDateService.save(typeDate);
    }

    @GetMapping
    public List<TypeDate> getTypeDateList () {
        return typeDateService.findAll();
    }

    @GetMapping("/{typeDateId}")
    public ResponseEntity<TypeDate> getTypeDateByID(@PathVariable("typeDateId") Long typeDateId) throws Exception {
        return  ResponseEntity.ok(typeDateService.findById(typeDateId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public TypeDate updateTypeDate(@RequestBody TypeDate typeDate){
        return typeDateService.updateTypeDate(typeDate);
    }

    @DeleteMapping(value = "/{typeDateId}")
    public ResponseEntity<TypeDate> deleteById(@PathVariable Long typeDateId){
        typeDateService.deleteTypeDate(typeDateId);
        return ResponseEntity.noContent().build();
    }
}
