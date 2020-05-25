package com.example.gatos_spring.repository;

import com.example.gatos_spring.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    User findByEmail(String email);
}
