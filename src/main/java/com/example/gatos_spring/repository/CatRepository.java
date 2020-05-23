package com.example.gatos_spring.repository;

import com.example.gatos_spring.entity.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CatRepository extends CrudRepository<Cat, UUID> {

}
