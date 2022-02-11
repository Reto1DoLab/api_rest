package com.Reto1.Reto1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCinemaRequest {
    private String email;
    private String username;
    private String password;
    private String web;
    private String address;
}
