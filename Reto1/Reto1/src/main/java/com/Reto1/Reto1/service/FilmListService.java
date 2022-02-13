package com.Reto1.Reto1.service;

import java.util.List;
import java.util.stream.Collectors;

import com.Reto1.Reto1.dto.FilmListDto;
import com.Reto1.Reto1.model.FilmList;
import com.Reto1.Reto1.repository.FilmListRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmListService implements FilmListServiceInterface{
    
    @Autowired
    private FilmListRepository repoFl;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FilmListDto get(Long id){
        FilmList FlEntity = repoFl.getById(id);
        FilmListDto FlDto = modelMapper.map(FlEntity,FilmListDto.class);

        return FlDto;
    }

    @Override
    public List<FilmListDto> getAll(){
        List<FilmList>listFlEntity = repoFl.findAll();
        List<FilmListDto> listFlDto = listFlEntity.stream().map(FilLit -> modelMapper.map(FilLit,FilmListDto.class)).collect(Collectors.toList());

        return listFlDto;
    }
}
