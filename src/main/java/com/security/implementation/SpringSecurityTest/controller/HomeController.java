package com.security.implementation.SpringSecurityTest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/casual")
    public ResponseEntity<String> casualUser(){
        return ResponseEntity.ok("Here is the casual user ");
    }


    @PreAuthorize("hasRole('ADMIN')")  //only accessible for defined ROLE
    @GetMapping("/admin")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("Here is the admin user ");
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("Here is the public user ");
    }
}
