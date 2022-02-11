package com.Reto1.Reto1.repository;

import java.util.Optional;

import com.Reto1.Reto1.model.Offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{
    Optional<Offer> findByDescription(String description);
}
