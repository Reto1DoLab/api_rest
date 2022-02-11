package com.Reto1.Reto1.model;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Director extends Film{
    @NotBlank(message = "Id is required")
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
}
