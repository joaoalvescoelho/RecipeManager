package com.example.recipemanager.Reporting;

import com.example.recipemanager.Models.Recipes;

import java.util.List;

public class SearchRecipe {

    private final List<Recipes> recipes;

    public SearchRecipe(List<Recipes> recipes) {
        this.recipes = recipes;
    }

    public List<Recipes> getRecipes() {
        return recipes;
    }
}
