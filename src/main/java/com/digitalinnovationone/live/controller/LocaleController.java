package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.Locale;
import com.digitalinnovationone.live.service.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/locale")
public class LocaleController {

    @Autowired
    LocaleService localeService;

    @PostMapping
    public Locale createLocale (@RequestBody Locale locale) {
        return localeService.save(locale);
    }

    @GetMapping
    public List<Locale> getLocaleList () {
        return localeService.findAll();
    }

    @GetMapping("/{localeId}")
    public ResponseEntity<Locale> getLocaleByID(@PathVariable("localeId") Long localeId) throws Exception {
        return  ResponseEntity.ok(localeService.findById(localeId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Locale updateLocale(@RequestBody Locale locale){
        return localeService.updateLocale(locale);
    }

    @DeleteMapping(value = "/{localeId}")
    public ResponseEntity<Locale> deleteById(@PathVariable Long localeId){
        localeService.deleteLocale(localeId);
        return ResponseEntity.noContent().build();
    }
}
