package com.example.study.service;

import com.example.study.model.Taco;
import com.example.study.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacoService {

    @Autowired
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
}
