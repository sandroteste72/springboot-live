package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.UserCategory;
import com.digitalinnovationone.live.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
public class UserCategoryController {

    @Autowired
    UserCategoryService userCategoryService;

    @PostMapping
    public UserCategory createCategory (@RequestBody UserCategory userCategory) {
        return userCategoryService.save(userCategory);
    }

    @GetMapping
    public List<UserCategory> getCategoryList () {
        return userCategoryService.findAll();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<UserCategory> getCategoryByID(@PathVariable("categoryId") Long categoryId) throws Exception {
        return  ResponseEntity.ok(userCategoryService.findById(categoryId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public UserCategory updateCategory(@RequestBody UserCategory userCategory){
        return userCategoryService.updateCategory(userCategory);
    }

    @DeleteMapping(value = "/{categoryId}")
    public ResponseEntity<UserCategory> deleteById(@PathVariable Long categoryId){
        userCategoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}
