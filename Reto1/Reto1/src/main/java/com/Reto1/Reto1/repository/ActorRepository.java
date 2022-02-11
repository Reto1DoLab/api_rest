package com.Reto1.Reto1.repository;

import java.util.Optional;

import com.Reto1.Reto1.model.Actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    Optional<Actor> findByName(String name);
}

