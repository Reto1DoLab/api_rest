package com.Reto1.Reto1.controller;

import java.util.HashMap;
import java.util.List;

import com.Reto1.Reto1.dto.FilmDto;
import com.Reto1.Reto1.dto.FilmListDto;
import com.Reto1.Reto1.form.FilmForm;
import com.Reto1.Reto1.service.IMSFilm;
import com.Reto1.Reto1.service.IMSFilmList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/film")
public class FilmController {
    
    IMSFilm filmsService;

    IMSFilmList filmsListService;

    @GetMapping("/show")
    public ModelAndView showFilm(){
        List<FilmDto> films=filmsService.getAll();
        List<FilmListDto> filmlists=filmsListService.getAll();

        var params = new HashMap<String,Object>();
        params.put("listFi", films);
        params.put("listFl", filmlists);

        return new ModelAndView("", params);
    }

    @GetMapping("/edit")
    public ModelAndView editFilm(@ModelAttribute("")long id){
        FilmForm form = new FilmForm();
        form.setFilm(filmsService.get(id));
        form.setLfilml(filmsListService.getAll());

        var params = new HashMap<String, Object>();
        params.put("form",form);

        return new ModelAndView("",params);
    }

    @PostMapping("/save")
    public ModelAndView saveFilm(FilmForm fiForm){
        filmsService.save(fiForm.getFilm());
        return new ModelAndView("");
    }
}
