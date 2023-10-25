package com.example.authservice.DTO;


import com.example.authservice.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long Id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
