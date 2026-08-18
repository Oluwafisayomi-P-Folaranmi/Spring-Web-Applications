package com.example.study.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Taco")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    @Column(name = "Name")
    private String name;

    @Column(name = "CreatedAt")
    @CreationTimestamp
    private Date createdAt = new Date();

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany()
    @Column(name = "Ingredients")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}