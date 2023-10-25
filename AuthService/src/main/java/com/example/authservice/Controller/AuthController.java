package com.example.authservice.Controller;


import com.example.authservice.DTO.UserDTO;
import com.example.authservice.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/create/")
    public ResponseEntity<?> creationOfUser(@RequestBody UserDTO userDTO){
        return userService.createNewUser(userDTO);
    }

    @PostMapping("/login/")
    public  ResponseEntity<?> login(@RequestBody UserDTO userDTO){ return userService.loginUser(userDTO); }
}
