package com.Reto1.Reto1.model;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cinema extends User{
    @NotBlank(message = "Web is required")
    private String web;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Offers is required")
    @OneToMany(mappedBy = "CinemaO")
    private List<Offer> offers;
} 
