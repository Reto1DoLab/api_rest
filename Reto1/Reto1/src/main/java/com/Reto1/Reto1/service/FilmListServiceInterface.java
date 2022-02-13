package com.Reto1.Reto1.service;

import java.util.List;

import com.Reto1.Reto1.dto.FilmListDto;

public interface FilmListServiceInterface{
    public FilmListDto get(Long id);
    public List<FilmListDto> getAll();
}
