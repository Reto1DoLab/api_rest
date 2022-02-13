package com.Reto1.Reto1.service;

import java.util.ArrayList;
import java.util.List;

import com.Reto1.Reto1.dto.FilmDto;
import com.Reto1.Reto1.model.Film;
import com.Reto1.Reto1.repository.FilmRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService implements FilmServiceInterface{

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
        try {
            List<FilmDto> films = new ArrayList<>();
            for( Film f : filmRepository.findAll() ){
                films.add( new FilmDto( f.getId(),
                                        f.getTitle(),
                                        f.getDescription(),
                                        f.getDate(),
                                        f.getUrlImage()
                                        ) );
            }
            return films;
        } catch (Exception e) {
            throw e;
        }
    }
}
