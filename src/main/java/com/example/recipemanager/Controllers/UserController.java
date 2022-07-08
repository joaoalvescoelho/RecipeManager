package com.example.recipemanager.Controllers;

import com.example.recipemanager.Reporting.FavRecipes;
import com.example.recipemanager.Reporting.SearchRecipe;
import com.example.recipemanager.Services.RecipeService;
import com.example.recipemanager.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/favRecipes")
    public String fav(Model model) {
        FavRecipes favRecipe = userService.getFavRecipes();
        model.addAttribute("favRecipes", favRecipe);

        return "favorite";
    }

    @GetMapping("/searchRecipes")
    public String create(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        SearchRecipe searchRecipes = recipeService.getAll();
        model.addAttribute("favRecipes", searchRecipes);

        return "favorite";
    }
}
