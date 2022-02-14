package com.Reto1.Reto1.controller;
import java.util.List;

import com.Reto1.Reto1.dto.OfferDTO;
import com.Reto1.Reto1.service.OfferService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/offer")
public class OfferController {

    private final OfferService offerService;
    @GetMapping("/show")
    public List<OfferDTO> getAllFilms(){
        return offerService.getAllOffers();
    }
}
