package com.example.study.repository;

import com.example.study.model.Ingredient;
import com.example.study.model.Taco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TacoRepository {

    public List<Taco> tacos = initialiseList();

    public List<Taco> findAll() {
        return tacos;
    }

    public Taco findById(Long id) {
        return tacos.get(Math.toIntExact(id));
    }

    public Taco save(Taco taco) {
        tacos.add(taco);
        return taco;
    }

    public Taco saveUpdate(Long id, Taco taco) {
        // We will find the taco with the `id` passed
        // We will update it and save it to the 'database'
        tacos.set(id.intValue(), taco);
        return tacos.get(id.intValue());
    }

    /** -------------------------------- Initialise tacos -------------------------------- */
    public static List<Taco> initialiseList() {
        // Create a list of Tacos
        List<Taco> tacos = new ArrayList<>();
        // 1. Create some Tacos
        // 2. Put ingredients into tacos

        // Create the first taco
        Taco tacos0 = new Taco("taco0", new ArrayList<>(), false);
        Ingredient ingredient1Taco0 = new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
        Ingredient ingredient2Taco0 =new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP);
        // Put ingredients into the tacos
        tacos0.addIngredient(ingredient1Taco0);
        tacos0.addIngredient(ingredient2Taco0);

        // Create the second taco
        Taco tacos1 = new Taco("taco1", new ArrayList<>(),false);
        Ingredient ingredient1Taco1 = new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
        Ingredient ingredient2Taco1 = new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN);
        Ingredient ingredient3Taco1 = new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES);
        // Put ingredients into the tacos
        tacos1.addIngredient(ingredient1Taco1);
        tacos1.addIngredient(ingredient2Taco1);
        tacos1.addIngredient(ingredient3Taco1);

        // Create the third taco
        Taco tacos2 = new Taco("taco2", new ArrayList<>(), false);
        Ingredient ingredient1Taco2 = new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES);
        // Put ingredients into the tacos
        tacos2.addIngredient(ingredient1Taco2);

        // Add the tacos to the list
        tacos.add(tacos0);
        tacos.add(tacos1);
        tacos.add(tacos2);

        return tacos;
    }
}
