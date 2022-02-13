package com.Reto1.Reto1.model;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Film{
    @Id
    @NotBlank(message = "Id is required")
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Date is required")
    private Date date;
    @NotBlank(message = "urlImage is required")
    private String urlImage;
    @NotBlank(message = "ListF is required")
    @ManyToOne
    @JoinColumn(name = "idListFK", insertable = false, updatable = false)
    private Film ListF;
    @NotBlank(message = "Directors is required")
    @OneToMany(mappedBy = "FilmD")
    private List<Director> directors;
    @NotBlank(message = "Categories is required")
    @OneToMany(mappedBy = "FilmC")
    private List<Category> Categories;
    @NotBlank(message = "ActorF is required")
    @ManyToOne
    @JoinColumn(name = "idActorFK", insertable = false, updatable = false)
    private Actor ActorF;
}
