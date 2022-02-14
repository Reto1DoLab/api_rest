package com.Reto1.Reto1.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDTO {
    private String description;
    private Date deadline;
    private Integer addPoints;
    private Integer subPoints;
    private String cinemaName;
    private String cinemaSurname;
}
