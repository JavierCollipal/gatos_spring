package com.example.gatos_spring.controller;

import com.example.gatos_spring.entity.Cat;
import com.example.gatos_spring.service.CatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class CatController {

    private final CatService catService;

    @GetMapping("/cats")
    public ResponseEntity<List<Cat>> getAllCats() {
        return catService.findAll();
    }

    @PostMapping("/cats")
    public ResponseEntity<Cat> createOneCat(@Valid @RequestBody Cat cat) {
        return catService.createOne(cat);
    }
}
