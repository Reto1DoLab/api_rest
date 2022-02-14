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
    public void save(FilmDto filmDto){
        try {
            Film film = new Film();
            film.setTitle(filmDto.getTitle());
            film.setDescription(filmDto.getDescription());
            film.setDate(filmDto.getDate());
            film.setUrlImage(filmDto.getUrlImage());
            filmRepository.save(film);  
        } catch (Exception e) {
            throw e;
        }
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
                films.add( new FilmDto( f.getTitle(),
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
