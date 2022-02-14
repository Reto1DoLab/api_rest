package com.Reto1.Reto1.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoRequest {
    private String email;
    private String username;
    private String name;
    private String surname;
}