package com.example.recipemanager.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipes", schema = "recipe_manager")
public class Recipes {

    @Id
    @Column(name = "id_recipe", nullable = false)
    private Long id_recipe;
    private String name;
    private String description;
    private String is_vegetarian;
    private String instructions;
    private String servings;

    public Recipes() {}

    public Long getIdRecipe() {
        return id_recipe;
    }

    public void setIdRecipe(Long id_recipe) {
        this.id_recipe = id_recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String isVegetarian() {
        return is_vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        is_vegetarian = vegetarian;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }
}