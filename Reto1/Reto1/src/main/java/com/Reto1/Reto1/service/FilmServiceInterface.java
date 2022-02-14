package com.Reto1.Reto1.service;

import java.util.List;

import com.Reto1.Reto1.dto.FilmDto;

public interface FilmServiceInterface {
    public void save(FilmDto Film);
    public FilmDto get(long id);
    public List<FilmDto> getAll();
}
