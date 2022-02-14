package com.Reto1.Reto1.model;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("cinema")
public class Cinema extends User{
    @NotBlank(message = "Web is required")
    private String web;
    @NotBlank(message = "Address is required")
    private String address;
    
    @OneToMany(mappedBy = "cinema")
    private List<Offer> offers;
} 
