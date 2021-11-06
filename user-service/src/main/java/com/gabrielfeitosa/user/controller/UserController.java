package com.gabrielfeitosa.user.controller;

import com.gabrielfeitosa.user.dto.UserCreateDTO;
import com.gabrielfeitosa.user.dto.UserDTO;
import com.gabrielfeitosa.user.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Map.Entry<String, List<UserDTO>>> listAll() {
        return ResponseEntity.ok(Map.entry("data", userService.listAll()));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserCreateDTO userCreateDTO) {
        userService.create(userCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
