package com.Reto1.Reto1.repository;

import java.util.Optional;

import com.Reto1.Reto1.model.Film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<Film> findByTitle(String title);
}
