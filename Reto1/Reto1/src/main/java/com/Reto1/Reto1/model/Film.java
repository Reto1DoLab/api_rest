package com.Reto1.Reto1.model;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static javax.persistence.GenerationType.IDENTITY;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Film{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Date is required")
    private Date date;
    @NotBlank(message = "urlImage is required")
    private String urlImage;
    
    @ManyToOne
    @JoinColumn(name = "idListFK", insertable = true, updatable = true)
    private Film ListF;

    @OneToMany(mappedBy = "FilmD")
    private List<Director> directors;

    @OneToMany(mappedBy = "FilmC")
    private List<Category> Categories;

    @ManyToOne
    @JoinColumn(name = "idActorFK", insertable = true, updatable = true)
    private Actor ActorF;
}
