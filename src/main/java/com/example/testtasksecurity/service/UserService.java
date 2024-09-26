package com.example.testtasksecurity.service;

import com.example.testtasksecurity.entity.UserEntity;
import com.example.testtasksecurity.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    UserRepo userRepo;
    private BCryptPasswordEncoder encoder(){return new BCryptPasswordEncoder();}

    public void saveUser(UserEntity userEntity){
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepo.save(userEntity);
    }

    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }
}
