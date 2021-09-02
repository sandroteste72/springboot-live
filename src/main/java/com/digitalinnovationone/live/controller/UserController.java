package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.Company;
import com.digitalinnovationone.live.model.User;
import com.digitalinnovationone.live.service.CompanyService;
import com.digitalinnovationone.live.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User createUser (@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> getUserList () {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByID(@PathVariable("userId") Long userId) throws Exception {
        return  ResponseEntity.ok(userService.findById(userId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<User> deleteById(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
