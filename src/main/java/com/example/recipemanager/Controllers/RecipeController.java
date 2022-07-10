package com.example.recipemanager.Controllers;

import com.example.recipemanager.Models.Recipes;
import com.example.recipemanager.Reporting.Recipe;
import com.example.recipemanager.Reporting.SearchRecipe;
import com.example.recipemanager.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/searchRecipes")
    public String search() {
        return "search";
    }

    @PostMapping("/searchResults")
    public String search(@RequestParam(name="veg", required=false) String isVeg, @RequestParam(name="ingredients", required=false, defaultValue = "") String ingredients,
                         @RequestParam(name="instructions", required=false, defaultValue = "") String instructions, @RequestParam(name="servings", required=false,  defaultValue = "") String servings,
                         @RequestParam(name="excludeIngredients", required=false, defaultValue = "") String exclude, Model model) {
        SearchRecipe searchRecipes = recipeService.getAllByFields(isVeg, ingredients,  instructions, servings, exclude);
        model.addAttribute("recipe", searchRecipes);

        return "results";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/createRecipes")
    public String createRecipe(@RequestParam(name="veg", required=false) String isVeg, @RequestParam(name="ingredients", required=false, defaultValue = "") String ingredients,
                               @RequestParam(name="instructions", required=false, defaultValue = "") String instructions, @RequestParam(name="servings", required=false,  defaultValue = "") String servings,
                               @RequestParam(name="name", required=false) String name, @RequestParam(name="description", required=false) String description, Model model) {
        Recipe createRecipe =  recipeService.createRecipe(name, description, isVeg, instructions, servings, ingredients);
        model.addAttribute("recipe", createRecipe);
        return "recipe";
    }

    @GetMapping("/manageRecipes")
    public String manage(Model model) {
        List<Recipes> searchRecipes = recipeService.getAllRecipes();
        model.addAttribute("allRecipes", searchRecipes);
        return "manage";
    }

    @PostMapping("/updateRecipe/{idRecipe}")
    public String updateRecipe(@PathVariable String idRecipe, Model model) {
        Recipe updatedRecipe = recipeService.getRecipeById(idRecipe);
        model.addAttribute("recipe", updatedRecipe);
        return "update";
    }

    @PostMapping("/updateRecipes/{id}")
    public String update(@PathVariable String id, @RequestParam(name="newName", required=false) String newName, @RequestParam(name="is_vegetarian", required=false) String isVeg,
                         @RequestParam(name="instructions", required=false, defaultValue = "") String instructions, @RequestParam(name="servings", required=false,  defaultValue = "") String servings,
                         @RequestParam(name="description", required=false) String description, @RequestParam(name="ingredients",required=false) String ingredients) {
        recipeService.updateRecipe(newName, description, isVeg, instructions, servings, ingredients, id);
        return "redirect:/manageRecipes";
    }

    @PostMapping("/deleteRecipe/{idRecipe}")
    public String deleteRecipe(@PathVariable String idRecipe) {
        recipeService.deleteRecipe(idRecipe);
        return "redirect:/manageRecipes";
    }

    @GetMapping("/home")
    public String myAction() {
        return "redirect:/";
    }
}
