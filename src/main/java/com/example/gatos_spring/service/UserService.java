package com.example.gatos_spring.service;

import com.example.gatos_spring.entity.User;
import com.example.gatos_spring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity singUp(User user) {
        User foundUser = userRepository.findByEmail(user.getEmail());

        if (foundUser.getId() == null) {
            userRepository.save(user);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
