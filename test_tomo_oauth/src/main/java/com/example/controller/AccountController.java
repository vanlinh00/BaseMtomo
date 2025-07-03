package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    //    @PreAuthorize("@roleChecker.hasValidRole(#principal)")
    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/me",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> user(Principal principal) {
        System.out.println(principal);

//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("messages",
//                String.format("Welcome again `%s`. And Happy nice day!", principal.getName()));
        return new ResponseEntity<>("hihi"/*jsonObject.toString()*/, HttpStatus.FOUND);
    }
}
