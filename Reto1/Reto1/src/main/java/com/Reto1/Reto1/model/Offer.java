package com.Reto1.Reto1.model;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Offer{
    @NotBlank(message = "Id is required")
    private Long id;
    @NotBlank(message = "Description is required")
    private String Description;
    @NotBlank(message = "Deadline is required")
    private Date Deadline;
    @NotBlank(message = "AddPoints is required")
    private Integer AddPoints;
    @NotBlank(message = "SubPoints is required")
    private Integer SubPoints;
    @NotBlank(message = "Cinemao is required")
    @ManyToOne
    @JoinColumn(name = "idCinemaFK", insertable = false, updatable = false)
    private Cinema CinemaO;
}
