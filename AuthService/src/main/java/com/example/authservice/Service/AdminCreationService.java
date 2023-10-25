package com.example.authservice.Service;


import com.example.authservice.DAO.UserDAO;
import com.example.authservice.Entity.Role;
import com.example.authservice.Entity.UsersEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminCreationService {

    private final UserDAO userDAO;

    public void createAdmin(){
        if(!ifAdminExist()){
            UsersEntity usersEntity = UsersEntity.builder()
                    .name("ADMIN")
                    .email("admin@gmail.com")
                    .password("admin")
                    .role(Role.ADMIN)
                    .build();

            userDAO.save(usersEntity);
        }
    }

    private boolean ifAdminExist(){
        List<UsersEntity> usersEntity = userDAO.findByRole(Role.ADMIN);
        if(usersEntity.size()==0){
            return false;
        }
        return true;
    }
}
