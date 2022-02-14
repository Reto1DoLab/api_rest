package com.Reto1.Reto1.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long userId;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Surname is required")
    private String surname;

    @OneToMany(mappedBy = "user")
    private List<FilmList> filmLists;

    private Instant created;
    private boolean enabled;
    
    @Transient
    public String getDecriminatorValue() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }
}