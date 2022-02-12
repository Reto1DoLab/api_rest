package com.Reto1.Reto1.model;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FilmList{
    @NotBlank(message = "Id is required")
    private Long id;
    @NotBlank(message = "Type is required")
    private List type;
    @NotBlank(message = "UserF is required")
    @ManyToOne
    @JoinColumn(name = "idUserFK", insertable = false, updatable = false)
    private User UserF;
    @NotBlank(message = "Films is required")
    @OneToMany(mappedBy = "ListF")
    private List<Film> films;
}
