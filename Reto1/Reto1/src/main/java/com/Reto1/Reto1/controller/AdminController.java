package com.Reto1.Reto1.controller;

import com.Reto1.Reto1.dto.RegisterCinemaRequest;
import com.Reto1.Reto1.service.AuthService;
import com.Reto1.Reto1.service.RefreshTokenService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {
    
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    
    @PostMapping("/create-cinema")
    public ResponseEntity<String> createCinema(@RequestBody RegisterCinemaRequest registerCinemaRequest) {
        authService.signUpCinema(registerCinemaRequest);
        return new ResponseEntity<>("Creation of cinema "+ registerCinemaRequest.getName()  +" Successful",
                 HttpStatus.OK);
    }


}
