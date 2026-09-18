package com.example.study.service;

import com.example.study.model.Taco;
import com.example.study.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacoService {

    private final TacoRepository tacoRepository;

    public TacoService(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    public Optional<List<Taco>> findAll() {
        List<Taco> tacos = tacoRepository.findAll();
        if (!(tacos.isEmpty())) {
            return Optional.of(tacos);
        }
        return Optional.empty();
    }

    public Optional<Taco> findById(Long id) {
        Taco taco = tacoRepository.findById((long) id);
        if (!(taco == null)) {
            return Optional.of(taco);
        }
        return Optional.empty();
    }

    public Optional<Taco> save(Taco taco) {
        Taco saved = tacoRepository.save(taco);
        if (saved == null) { // if null
            return Optional.empty();
        }
        return Optional.of(saved); // if not null
    }

    public Optional<Taco> saveUpdate(Long id, Taco taco) {
        // We will get the taco with the id
        Taco querried = tacoRepository.findById(id);
        // We want to check the properties of the taco
        if(taco.getName() != null) {
            querried.setName(taco.getName());
        }
        if(taco.getIngredients() != null) {
            querried.setIngredients(taco.getIngredients());
        }
        if(taco.isSalted()) {
            querried.setSalted(true);
        }
        // Save the `queried` taco back into the 'database'
        Taco updated = tacoRepository.saveUpdate(id, querried);
        if (updated == null) {
            return Optional.empty();
        }
        return Optional.of(updated);
    }
}
