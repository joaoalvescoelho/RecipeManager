package com.example.recipemanager.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipesingredients", schema = "recipe_manager")
public class RecipeIngredients {

    @Id
    private Long id_ingredients;
    private Long id_recipes;

    public RecipeIngredients() {}

    public Long getIdIngredients() {
        return id_ingredients;
    }

    public void setIdIngredients(Long id_ingredients) {
        this.id_ingredients = id_ingredients;
    }

    public Long getIdRecipe() {
        return id_recipes;
    }

    public void setIdRecipe(Long idRecipe) {
        this.id_recipes = id_recipes;
    }
}
