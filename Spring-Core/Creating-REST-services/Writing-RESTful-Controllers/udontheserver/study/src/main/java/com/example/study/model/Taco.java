package com.example.study.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Taco {

    private String name;

    private List<Ingredient> ingredients;

    private boolean salted;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
