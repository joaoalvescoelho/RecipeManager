package com.example.recipemanager.Services;

import com.example.recipemanager.Models.Recipes;
import com.example.recipemanager.Reporting.Recipe;
import com.example.recipemanager.Reporting.SearchRecipe;
import com.example.recipemanager.Repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public SearchRecipe getAllByFields(String veg, String ingredients, String instructions, String servings, String exclude) {
        SearchRecipe result;
        List<Recipes> allRecipes;

        if(!veg.equals("") || !ingredients.equals("") || !exclude.equals("") || !instructions.equals("")) {
            if (!exclude.equals("")) {
                if(servings.equals("")) {
                    allRecipes = recipeRepository.getByInputsWithoutServingsAndExcludeIngredients(exclude, veg, instructions);
                } else {
                    allRecipes = recipeRepository.getByInputsWithServingsAndExcludeIngredients(exclude, veg, instructions, servings);
                }
            } else {
                if(servings.equals("")) {
                    allRecipes = recipeRepository.getByInputsWithoutServings(ingredients, veg, instructions);
                } else {
                    allRecipes = recipeRepository.getByInputsWithServings(ingredients, veg, instructions, servings);
                }
            }

        }
        else {
            allRecipes = recipeRepository.getAllRecipes();
        }
        result = new SearchRecipe(allRecipes);

        return result;
    }

    public Recipe createRecipe(String name, String description, String isVeg, String instructions, String servings, String ingredients) {
        Recipe result;
        List<String> listIngredients = List.of(ingredients.replaceAll(" ", "").split(","));
        recipeRepository.createRecipe(name, description, isVeg, instructions, servings);
        Recipes newRecipe = recipeRepository.lastRecipe();
        for (String ingredient : listIngredients) {
            if(recipeRepository.findIngredientByName(ingredient) == null) {
                recipeRepository.createIngredient(ingredient);
            }
            recipeRepository.createRecipeIngredients(newRecipe.getIdRecipe().toString(), ingredient);
        }

        Recipes recipe = recipeRepository.findByName(name);
        List<String> ings = recipeRepository.findIngredientByRecipeId(recipe.getIdRecipe());
        result = new Recipe(recipe.getIdRecipe().toString(), recipe.getName(), recipe.getDescription(), recipe.isVegetarian(), recipe.getInstructions(), recipe.getServings(), ings.toString());

        return result;
    }

    public List<Recipes> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(String idRecipe) {
        Recipe result;

        Recipes recipe = recipeRepository.findRecipeById(idRecipe);
        List<String> ings = recipeRepository.findIngredientByRecipeId(recipe.getIdRecipe());
        result = new Recipe(recipe.getIdRecipe().toString(), recipe.getName(), recipe.getDescription(), recipe.isVegetarian(), recipe.getInstructions(), recipe.getServings(), ings.toString());
        return result;
    }

    public void updateRecipe(String name, String description, String vegetarian, String instructions, String servings, String ingredients, String idRecipe) {
        Recipes recipe = recipeRepository.findRecipeById(idRecipe);
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setVegetarian(vegetarian);
        recipe.setInstructions(instructions);
        recipe.setServings(servings);

        recipeRepository.deleteIngredientsRecipeRelationsById(recipe.getIdRecipe());
        List<String> listIngredients = List.of(ingredients.substring(1,ingredients.length()-1).replaceAll(" ", "").split(","));
        for (String ingredient : listIngredients) {
            if(recipeRepository.findIngredientByName(ingredient) == null) {
                recipeRepository.createIngredient(ingredient);
            }
            recipeRepository.createRecipeIngredients(recipe.getIdRecipe().toString(), ingredient);
        }

        recipeRepository.save(recipe);
    }

    public void deleteRecipe(String idRecipe) {
        recipeRepository.delete(idRecipe);
    }
}
