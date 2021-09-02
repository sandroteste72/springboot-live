package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.Locale;
import com.digitalinnovationone.live.repository.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocaleService {

    LocaleRepository localeRepository;

    @Autowired
    public LocaleService(LocaleRepository localeRepository) {
        this.localeRepository = localeRepository;
    }

    public Locale save (Locale locale) {
        return localeRepository.save(locale);
    }

    public List<Locale> findAll() {
        return localeRepository.findAll();
    }

    public Optional<Locale> findById(Long localeId) {
        return localeRepository.findById(localeId);
    }

    public Locale updateLocale(Locale locale){
        return localeRepository.save(locale);
    }

    public void deleteLocale(Long localeId) {
        localeRepository.deleteById(localeId);
    }
}
