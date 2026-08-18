package com.example.demo.model;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Taco {

    private String name;

    private List<Ingredient> ingredients;
}
