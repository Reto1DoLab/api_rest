package com.Reto1.Reto1.dto;

import com.Reto1.Reto1.model.Cinema;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOfferRequest {
    private String description;
    private Date deadline;
    private Integer addPoints;
    private Integer subPoints;
    private String cinemaUsername;
}
