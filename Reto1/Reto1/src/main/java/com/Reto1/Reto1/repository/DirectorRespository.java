package com.Reto1.Reto1.repository;

import java.util.Optional;

import com.Reto1.Reto1.model.Director;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRespository extends JpaRepository<Director, Long> {
    Optional<Director> findByName(String name);
}
