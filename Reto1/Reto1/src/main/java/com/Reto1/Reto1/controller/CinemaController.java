package com.Reto1.Reto1.controller;

import com.Reto1.Reto1.dto.CreateOfferRequest;
import com.Reto1.Reto1.service.AuthService;
import com.Reto1.Reto1.service.OfferService;
import com.Reto1.Reto1.service.RefreshTokenService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cinema")
@AllArgsConstructor
public class CinemaController {
    
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    private final OfferService offerService;
    
    @PostMapping("/create-offer")
    public ResponseEntity<String> createCinema(@RequestBody CreateOfferRequest createOfferRequest) {
        offerService.createOffer(createOfferRequest);
        return new ResponseEntity<>("Creation of cinema "+ createOfferRequest.getDescription()  +" Successful",
                 HttpStatus.OK);
    }


}
