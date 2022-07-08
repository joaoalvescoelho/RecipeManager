package com.example.recipemanager.Services;

import com.example.recipemanager.Models.Recipes;
import com.example.recipemanager.Reporting.FavRecipes;
import com.example.recipemanager.Reporting.RecipesName;
import com.example.recipemanager.Reporting.SearchRecipe;
import com.example.recipemanager.Repositories.RecipeRepository;
import com.example.recipemanager.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public SearchRecipe getAll() {
        SearchRecipe result;
        List<Recipes> allRecipes = recipeRepository.queryAll();

        result = new SearchRecipe(allRecipes);

        return result;
    }
}
