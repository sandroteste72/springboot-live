package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.AccessLevel;
import com.digitalinnovationone.live.repository.AccessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {

    AccessLevelRepository accessLevelRepository;

    @Autowired
    public AccessLevelService(AccessLevelRepository accessLevelRepository) {
        this.accessLevelRepository = accessLevelRepository;
    }

    public AccessLevel save (AccessLevel accessLevel) {
        return accessLevelRepository.save(accessLevel);
    }

    public List<AccessLevel> findAll() {
        return accessLevelRepository.findAll();
    }

    public Optional<AccessLevel> findById(Long accessLevelId) {
        return accessLevelRepository.findById(accessLevelId);
    }

    public AccessLevel updateAccessLevel(AccessLevel accessLevel){
        return accessLevelRepository.save(accessLevel);
    }

    public void deleteAccessLevel(Long accessLevelId) {
        accessLevelRepository.deleteById(accessLevelId);
    }
}
