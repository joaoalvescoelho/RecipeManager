package com.example.recipemanager.Controllers;


import com.example.recipemanager.Reporting.FavRecipes;
import com.example.recipemanager.Services.RecipeService;
import com.example.recipemanager.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/favoriteRecipes")
    public String favorite(Model model) {
        FavRecipes favRecipe = userService.getFavRecipes();
        model.addAttribute("favRecipes", favRecipe);

        return "favorite";
    }

    @GetMapping("/makeFavorite/{idRecipe}")
    public String makeFavorite(@PathVariable String idRecipe) {
        userService.setFavoriteRecipe(idRecipe);
        return "redirect:/manageRecipes";
    }

}
