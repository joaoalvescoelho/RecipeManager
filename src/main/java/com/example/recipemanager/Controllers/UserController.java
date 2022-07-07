package com.example.recipemanager.Controllers;

import com.example.recipemanager.Reporting.SearchRecipe;
import com.example.recipemanager.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/favRecipes")
    public String user(Model model) {
        SearchRecipe favRecipe = userService.getFavRecipes();
        model.addAttribute("favRecipes", favRecipe);

        return "favorite";
    }
}
