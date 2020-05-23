package com.example.gatos_spring.service;

import com.example.gatos_spring.entity.Cat;
import com.example.gatos_spring.repository.CatRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service()
public class CatService {

    private final CatRepository catRepository;

    public ResponseEntity<List<Cat>> findAll() {
        List<Cat> foundCats = (List<Cat>) catRepository.findAll();
        return ResponseEntity.ok().body(foundCats);
    }

    public ResponseEntity<Cat> createOne(Cat cat) {
        Cat savedCat = catRepository.save(cat);
        return ResponseEntity.status(201).body(savedCat);
    }

    public ResponseEntity<Cat> getOne(UUID id) {
        return catRepository
                .findById(id)
                .map(foundCat -> ResponseEntity.ok().body(foundCat))
                .orElse(ResponseEntity.noContent().build());
    }

    public ResponseEntity<Cat> deleteOne(UUID id) {
        return catRepository.findById(id)
                .map(foundCat -> {
                    catRepository.delete(foundCat);
                    return ResponseEntity.ok().body(foundCat);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Cat> updateOne(UUID id, Cat cat) {

        return catRepository
                .findById(id)
                .map(foundCat -> {
                    foundCat.setName(cat.getName());
                    foundCat.setAge(cat.getAge());
                    catRepository.save(foundCat);
                    return ResponseEntity.ok().body(foundCat);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
