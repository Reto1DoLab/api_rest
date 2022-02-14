package com.Reto1.Reto1.service;

import java.util.ArrayList;
import java.util.Optional;

import java.util.List;
import com.Reto1.Reto1.dto.CreateOfferRequest;
import com.Reto1.Reto1.dto.OfferDTO;
import com.Reto1.Reto1.model.Cinema;
import com.Reto1.Reto1.model.Offer;
import com.Reto1.Reto1.repository.CinemaRepository;
import com.Reto1.Reto1.repository.OfferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private CinemaRepository cinemaRepository;

    
    public void createOffer(CreateOfferRequest createOfferRequest){
        try {
            Offer offer = new Offer();
            offer.setDescription(createOfferRequest.getDescription());
            offer.setDeadline(createOfferRequest.getDeadline());
            offer.setAddPoints(createOfferRequest.getAddPoints());
            offer.setSubPoints(createOfferRequest.getSubPoints());

            String cinemaUsername = createOfferRequest.getCinemaUsername();
            
            Optional<Cinema> cinemaOptional = cinemaRepository.findByUsername(cinemaUsername);
            Cinema cinema = cinemaOptional
                .orElseThrow(() -> new UsernameNotFoundException("No user cinema" +
                        "Found with username : " + cinemaUsername)); 
            offer = offerRepository.save(offer);
            offer.setCinema(cinema);
            /*offerRepository.updateOffer(offer.getIdOffer(),
                                        offer.getDescription(),
                                        offer.getDeadline(),
                                        offer.getAddPoints(),
                                        offer.getSubPoints(),
                                        offer.getCinema());*/
            offerRepository.save(offer);  
        } catch (Exception e) {
            throw e;
        }
    }

    public List<OfferDTO> getAllOffers() {
        try {
            List<OfferDTO> offers = new ArrayList<>();
            for( Offer o : offerRepository.findAll() ){
                Optional<Cinema> cinemaOptional = cinemaRepository.findByUsername(o.getCinema().getUsername());
                Cinema cinema = cinemaOptional
                .orElseThrow(() -> new UsernameNotFoundException("No user cinema" +
                        "Found with username : " + o.getCinema().getUsername()));
                offers.add( new OfferDTO( o.getDescription(),
                                         o.getDeadline(),
                                         o.getAddPoints(),
                                         o.getSubPoints(),
                                         cinema.getName(),
                                         cinema.getSurname()
                                         ) );
            }
            return offers;
        } catch (Exception e) {
            throw e;
        }
    
    }


    
}
