package com.Reto1.Reto1.repository;

import java.util.Optional;

import com.Reto1.Reto1.model.FilmList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antlr.collections.List;

@Repository
public interface FilmListRepository extends JpaRepository<FilmList, Long>{
    Optional<FilmList> findByType(List type);
}
