package com.example.recipemanager.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients", schema = "recipe_manager")
public class Ingredients {

    @Id
    @Column(name = "id_ingredients", nullable = false)
    private Long id_ingredients;
    @Column(name="name")
    private String name;

    public Ingredients() {}

    public Long getIdIngredients() {
        return id_ingredients;
    }

    public void setIdIngredients(Long id_ingredients) {
        this.id_ingredients = id_ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}