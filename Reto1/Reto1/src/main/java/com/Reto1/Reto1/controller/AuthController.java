package com.Reto1.Reto1.controller;

import com.Reto1.Reto1.dto.AuthenticationResponse;
import com.Reto1.Reto1.dto.LoginRequest;
import com.Reto1.Reto1.dto.RegisterCinemaRequest;
import com.Reto1.Reto1.dto.RegisterRequest;
import com.Reto1.Reto1.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest) {
        authService.signUp(registerRequest);
        return new ResponseEntity<>("Subscriber Registration Successful",
                 HttpStatus.OK);
    }
    @PostMapping("/create-cinema")
    public ResponseEntity<String> signUp(@RequestBody RegisterCinemaRequest registerCinemaRequest) {
        authService.signUpCinema(registerCinemaRequest);
        return new ResponseEntity<>("Cinema Registration Successful",
                 HttpStatus.OK);
    }
    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token){
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Success",HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
    

}