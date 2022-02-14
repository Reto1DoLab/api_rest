package com.Reto1.Reto1.model;
import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Offer{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idOffer;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Deadline is required")
    private Date deadline;
    @NotNull(message = "AddPoints is required")
    private Integer addPoints;
    @NotNull(message = "SubPoints is required")
    private Integer subPoints;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = true)
    private Cinema cinema;
}
