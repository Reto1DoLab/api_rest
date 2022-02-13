package com.Reto1.Reto1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.type.ListType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmListDto {
    private long id;
    private ListType type;
    private long idUserFK;
}
