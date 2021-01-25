package com.devsuperior.hruser.controllers;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.ok(user.get());
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findById(@RequestParam String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        return ResponseEntity.ok(user.get());
    }
}
