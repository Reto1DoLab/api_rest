package com.Reto1.Reto1.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto {
    private long id;
    private String title;
    private String description;
    private Date date;
    private String urlImage;
}
