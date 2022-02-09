package com.Reto1.Reto1.model;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cinema extends User{
    @NotBlank(message = "Web is required")
    private String web;
    @NotBlank(message = "Address is required")
    private String address;
}
