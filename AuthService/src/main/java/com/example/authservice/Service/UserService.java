package com.example.authservice.Service;
import com.example.authservice.DAO.UserDAO;
import com.example.authservice.DTO.UserDTO;
import com.example.authservice.Entity.Role;
import com.example.authservice.Entity.UsersEntity;
import com.example.authservice.Filter.JwtServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {


    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtServices jwtServices;


    public ResponseEntity<?> createNewUser(UserDTO userDTO){
        UsersEntity usersEntity = UsersEntity.builder()
                .role(Role.CUSTOMER)
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();
        return new ResponseEntity<>(userDAO.save(usersEntity), HttpStatus.OK);
    }

    public ResponseEntity<?> loginUser(UserDTO userDTO){
        try{
            UsersEntity usersEntity = userDAO.findByEmail(userDTO.getEmail());
            if(usersEntity==null){
                throw new UsernameNotFoundException("The User Not Exist");
            }
            try{
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getEmail(),userDTO.getPassword()));
                return new ResponseEntity<>(jwtServices.getJwtToken(usersEntity),HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>("Invalid Access Credentials",HttpStatus.FORBIDDEN);
            }
        }catch (Exception e){
            return new ResponseEntity<>("SERVER ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
