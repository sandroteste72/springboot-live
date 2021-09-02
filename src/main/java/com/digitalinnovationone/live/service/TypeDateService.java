package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.TypeDate;
import com.digitalinnovationone.live.repository.TypeDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeDateService {

    TypeDateRepository typeDateRepository;

    @Autowired
    public TypeDateService(TypeDateRepository typeDateRepository) {
        this.typeDateRepository = typeDateRepository;
    }

    public TypeDate save (TypeDate typeDate) {
        return typeDateRepository.save(typeDate);
    }

    public List<TypeDate> findAll() {
        return typeDateRepository.findAll();
    }

    public Optional<TypeDate> findById(Long typeDateId) {
        return typeDateRepository.findById(typeDateId);
    }

    public TypeDate updateTypeDate(TypeDate typeDate){
        return typeDateRepository.save(typeDate);
    }

    public void deleteTypeDate(Long typeDateId) {
        typeDateRepository.deleteById(typeDateId);
    }
}
