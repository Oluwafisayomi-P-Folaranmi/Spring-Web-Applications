package com.example.demo.service;

import com.example.demo.model.Ingredient;
import com.example.demo.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    public final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findByType(Ingredient.Type type) {
        return ingredientRepository.findByType(type);
    }
}
