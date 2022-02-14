package com.Reto1.Reto1.controller;

import java.util.HashMap;
import java.util.List;

import com.Reto1.Reto1.dto.FilmDto;
import com.Reto1.Reto1.form.FilmForm;
import com.Reto1.Reto1.service.FilmListService;
import com.Reto1.Reto1.service.FilmService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/film")
public class FilmController {
    
    private final FilmService filmsService;
    private final FilmListService filmListService;

    @GetMapping("/show")
    public List<FilmDto> getAllFilms(){
        return filmsService.getAll();
    }

    @GetMapping("/edit")
    public ModelAndView editFilm(@ModelAttribute("")long id){
        FilmForm form = new FilmForm();
        form.setFilm(filmsService.get(id));
        form.setLfilml(filmListService.getAll());

        var params = new HashMap<String, Object>();
        params.put("form",form);

        return new ModelAndView("",params);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveFilm(@RequestBody FilmDto filmDto){
        filmsService.save(filmDto);
        return new ResponseEntity<>("Creation of movie "+ filmDto.getTitle()  +" Successful",
                 HttpStatus.OK);
        
    }
}
