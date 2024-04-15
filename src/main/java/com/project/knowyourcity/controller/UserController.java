package com.project.knowyourcity.controller;

import com.project.knowyourcity.dto.UserDto;
import com.project.knowyourcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This supports all user opertations
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/hello")
    public ResponseEntity<String> HelloWorld() {
        return new ResponseEntity<>("Say Hello",HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> listUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> insertUser(@RequestBody UserDto newUser){
        UserDto retUser = userService.insertNewUser(newUser);
        return new ResponseEntity<>(retUser,HttpStatus.OK);
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto user){
        UserDto retUser = userService.loginUser(user);
        return new ResponseEntity<>(retUser,HttpStatus.OK);
    }
}
