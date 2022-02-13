package com.Reto1.Reto1.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FilmList{
    @Id
    @NotBlank(message = "Id is required")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private ListType type;
    @NotBlank(message = "UserF is required")
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User user;
    @OneToMany(mappedBy = "ListF")
    private List<Film> films;
}
