package com.Reto1.Reto1.service;

import java.util.List;

import com.Reto1.Reto1.dto.FilmDto;

public interface ISFilm {
    public FilmDto save(FilmDto Film);
    public FilmDto get(long id);
    public List<FilmDto> getAll();
}
