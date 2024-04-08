package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@RequestBody User user) {
    User savedUser = userService.registerUser(user);
    return ResponseEntity.ok(savedUser);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable Long id) {
    return userService.getUserById(id)
        .map(user -> ResponseEntity.ok(user))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
