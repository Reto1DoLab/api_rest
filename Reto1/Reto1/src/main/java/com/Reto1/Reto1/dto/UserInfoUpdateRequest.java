package com.Reto1.Reto1.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoUpdateRequest {
    @NotBlank
    private String refreshToken;
    private String email;
    private String username;
    private String name;
    private String surname;
    private String password;
}
