package com.example.gatos_spring.controller;

import com.example.gatos_spring.entity.Cat;
import com.example.gatos_spring.service.CatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class CatController {

    private final CatService catService;

    @GetMapping("/cats")
    public ResponseEntity<List<Cat>> getAllCats() {
        return catService.findAll();
    }

    @GetMapping("/cats/{id}")
    public ResponseEntity<Cat> getOneCat(@PathVariable UUID id) {
        return catService.getOne(id);
    }

    @PostMapping("/cats")
    public ResponseEntity<Cat> createOneCat(@Valid @RequestBody Cat cat) {
        return catService.createOne(cat);
    }

    @DeleteMapping("/cats/{id}")
    public ResponseEntity<Cat> deleteOneCat(@PathVariable UUID id) {
        return catService.deleteOne(id);
    }

    @PutMapping("/cats/{id}")
    public ResponseEntity<Cat> updateOneCat(@PathVariable UUID id, @RequestBody Cat cat) {
        return catService.updateOne(id, cat);
    }
}
