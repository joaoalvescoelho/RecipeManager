package com.example.recipemanager.Models;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipes {
    @Id
    @Column(name = "idRecipes", nullable = false)
    private Long idRecipes;
    private String recipe;
    private List<Ingredients> ingredients;
    private String instructions;

    public Recipes() {}

    public Long getIdRecipes() {
        return idRecipes;
    }

    public void setIdRecipes(Long idUsers) {
        this.idRecipes = idUsers;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String nameUsers) {
        this.recipe = nameUsers;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String favRecipes) {
        this.ingredients = favRecipes;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}