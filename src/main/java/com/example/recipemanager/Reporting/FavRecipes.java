package com.example.recipemanager.Reporting;

import java.util.List;

public class FavRecipes {

    private final List<RecipesName> favs;

    public FavRecipes(List<RecipesName> favs) {
        this.favs = favs;
    }

    public List<RecipesName> getFavs() {
        return favs;
    }
}
