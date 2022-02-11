package com.Reto1.Reto1.model;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Offer extends Cinema{
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
}
