package com.blog.app.controller;

import com.blog.app.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestRestController {
    @Autowired
    UsersService usersService;
    @GetMapping("/logins")
    public ResponseEntity<?> testLogin(){
        return ResponseEntity.ok("");
    }

}
