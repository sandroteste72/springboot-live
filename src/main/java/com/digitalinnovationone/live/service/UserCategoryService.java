package com.digitalinnovationone.live.service;

import com.digitalinnovationone.live.model.UserCategory;
import com.digitalinnovationone.live.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoryService {

    UserCategoryRepository userCategoryRepository;

    @Autowired
    public UserCategoryService(UserCategoryRepository userCategoryRepository) {
        this.userCategoryRepository = userCategoryRepository;
    }

    public UserCategory save (UserCategory userCategory) {
        return userCategoryRepository.save(userCategory);
    }

    public List<UserCategory> findAll() {
        return userCategoryRepository.findAll();
    }

    public Optional<UserCategory> findById(Long categoryId) {
        return userCategoryRepository.findById(categoryId);
    }

    public UserCategory updateCategory(UserCategory userCategory){
        return userCategoryRepository.save(userCategory);
    }

    public void deleteCategory(Long categoryId) {
        userCategoryRepository.deleteById(categoryId);
    }
}
