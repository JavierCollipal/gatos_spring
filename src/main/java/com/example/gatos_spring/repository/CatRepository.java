package com.example.gatos_spring.repository;

import com.example.gatos_spring.entity.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<Cat, String> {

}
