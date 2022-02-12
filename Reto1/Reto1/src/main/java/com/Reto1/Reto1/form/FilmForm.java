package com.Reto1.Reto1.form;

import java.util.List;

import com.Reto1.Reto1.dto.FilmDto;
import com.Reto1.Reto1.dto.FilmListDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmForm {
    private FilmDto Film;
    private FilmListDto FilmList;
    private List<FilmListDto> lfilml;
}
