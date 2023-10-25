package com.example.authservice.DAO;

import com.example.authservice.Entity.Role;
import com.example.authservice.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserDAO extends JpaRepository<UsersEntity,Long> {
    List<UsersEntity> findByRole(Role role);
    UsersEntity findByEmail(String email);
}
