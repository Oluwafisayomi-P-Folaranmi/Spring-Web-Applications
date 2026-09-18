package com.example.study.controller;

import com.example.study.model.Taco;
import com.example.study.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api", produces="application/json")
@CrossOrigin(origins="http://tacocloud:8080")
public class TacoController {

    @Autowired
    TacoService tacoService;

    public TacoController(TacoService tacoService) {
        this.tacoService = tacoService;
    }

    @GetMapping(path = "/tacos")
    public ResponseEntity<List<Taco>> getTacos() {
        Optional<List<Taco>> tacos = tacoService.findAll();
        if (!(tacos.isPresent())) { // if not present
            throw new RuntimeException("There are no tacos yet.");
        }
        return new ResponseEntity<>(tacos.get(), HttpStatus.FOUND); // if present
    }

    @GetMapping(path = "/taco/{id}")
    public ResponseEntity<Taco> getTaco(@PathVariable Long id) {
        Optional<Taco> taco = tacoService.findById(id);
        if (!(taco.isPresent())) { // if not present
            throw new RuntimeException("There is no taco with the id :" + id);
        }
        return new ResponseEntity<>(taco.get(), HttpStatus.FOUND); // if present
    }

    @PostMapping(path = "/taco", consumes = "application/json")
    public ResponseEntity<Taco> saveTaco(@RequestBody Taco taco) {
        Optional<Taco> saved = tacoService.save(taco);
        if (saved.isEmpty()) { // if null
            throw new RuntimeException("Nothing is saved.");
        }
        return new ResponseEntity<>(saved.get(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/taco/{id}", produces = "application/json")
    public ResponseEntity<Taco> putTaco(@PathVariable("id") Long id, @RequestBody Taco taco) {
        Optional<Taco> put = tacoService.saveUpdate(id, taco);
        if (put.isEmpty()) {
            throw new RuntimeException("Not put yet.");
        }
        return new ResponseEntity<>(put.get(), HttpStatus.OK);
    }

    @PatchMapping(value = "/taco/{id}", produces = "application/json")
    public ResponseEntity<Taco> patchTaco(@PathVariable("id") Long id, @RequestBody Taco taco) {
        Optional<Taco> patch = tacoService.saveUpdate(id, taco);
        if (patch.isEmpty()) {
            throw new RuntimeException("Not patched yet.");
        }
        return new ResponseEntity<>(patch.get(), HttpStatus.OK);
    }
}
