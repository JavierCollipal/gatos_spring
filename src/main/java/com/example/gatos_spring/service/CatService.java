package com.example.gatos_spring.service;

import com.example.gatos_spring.entity.Cat;
import com.example.gatos_spring.repository.CatRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service()
public class CatService {

    private final CatRepository catRepository;

    public ResponseEntity<List<Cat>> findAll() {
        List<Cat> foundCats = (List<Cat>) catRepository.findAll();
        int responseCode;

        //if the list is empty, no content HTTP code is returned.
        if (foundCats.size() > 0) responseCode = 200;
        else responseCode = 204;

        return ResponseEntity.status(responseCode).body(foundCats);
    }

    public ResponseEntity<Cat> createOne(Cat cat) {
        Cat savedCat = catRepository.save(cat);
        return ResponseEntity.status(201).body(savedCat);
    }
}
