package com.Reto1.Reto1.model;
import javax.validation.constraints.NotBlank;
import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FilmList extends User{
    @NotBlank(message = "Id is required")
    private Long id;
    @NotBlank(message = "Type is required")
    private List type;
}
