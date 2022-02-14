package com.Reto1.Reto1.repository;

import java.sql.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import com.Reto1.Reto1.model.Cinema;
import com.Reto1.Reto1.model.Offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{
    Optional<Offer> findByDescription(String description);

    @Transactional
    @Modifying
    @Query(value = "UPDATE offer SET description=?2, deadline=?3, addPoints=?4, subPoints=?5, cinema=?6 WHERE id=?1", nativeQuery = true)
    void updateOffer(Long id, String description,Date deadline, Integer addPoints, Integer subPoints, Cinema cinema);
}
