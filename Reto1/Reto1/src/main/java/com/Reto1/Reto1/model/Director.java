package com.Reto1.Reto1.model;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Director{
    @Id
    @NotBlank(message = "Id is required")
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "FilmD is required")
    @ManyToOne
    @JoinColumn(name = "idFilmFK", insertable = false, updatable = false)
    private Film FilmD;
}
