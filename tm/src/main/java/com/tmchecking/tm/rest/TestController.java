package com.tmchecking.tm.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 */
@RestController
public class TestController {

    @PostMapping("/test-controller")
    public ResponseEntity<?> test(){
        return ResponseEntity.accepted().build();
    }
    
}