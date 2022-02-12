package com.Reto1.Reto1.service;

import java.util.List;
import java.util.stream.Collectors;

import com.Reto1.Reto1.dto.FilmDto;
import com.Reto1.Reto1.model.Film;
import com.Reto1.Reto1.repository.FilmRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMSFilm implements FilmServiceInterface{

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FilmDto save(FilmDto Film){
        Film FiEntity = modelMapper.map(Film, Film.class);
        FiEntity = filmRepository.save(FiEntity);

        return modelMapper.map(FiEntity,FilmDto.class);
    }

    @Override
    public FilmDto get(long id){
        Film FiEntity = filmRepository.getById(id);
        FilmDto FiDto = modelMapper.map(FiEntity,FilmDto.class);

        return FiDto;
    }

    @Override
    public List<FilmDto> getAll(){
        List<Film>listFiEntity = filmRepository.findAll();
        List<FilmDto> listFiDto = listFiEntity.stream().map(Fil -> modelMapper.map(Fil,FilmDto.class)).collect(Collectors.toList());

        return listFiDto;
    }
}
