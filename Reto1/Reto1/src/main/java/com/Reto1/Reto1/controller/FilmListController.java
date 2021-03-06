package com.Reto1.Reto1.controller;

import java.util.HashMap;
import java.util.List;

import com.Reto1.Reto1.dto.FilmListDto;
import com.Reto1.Reto1.dto.RegisterRequest;
import com.Reto1.Reto1.service.FilmListService;
import com.Reto1.Reto1.service.UserDetailsServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/FilmList")
public class FilmListController {

    @Autowired
    FilmListService filmListService;
    
    @Autowired
    UserDetailsServicesImpl userDetailsService;
    
    @GetMapping("/show")
    public ModelAndView showFilmList(){

        List<FilmListDto> filmlists = filmListService.getAll();
        List<RegisterRequest> users = userDetailsService.getAll();

        var params = new HashMap<String,Object>();
        params.put("listFl", filmlists);
        params.put("listUs", users);

        return new ModelAndView("", params);
    }
}
