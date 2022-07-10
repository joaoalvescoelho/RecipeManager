package com.example.recipemanager.Services;

import com.example.recipemanager.Reporting.FavRecipes;
import com.example.recipemanager.Reporting.RecipesName;
import com.example.recipemanager.Repositories.RecipeRepository;
import com.example.recipemanager.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    public FavRecipes getFavRecipes() {
        List<RecipesName> favRecipes = userRepository.queryFavRecipes();

        return new FavRecipes(favRecipes);
    }

    public void setFavoriteRecipe(String idRecipe) {
        if(userRepository.findFavoriteById(idRecipe).isEmpty()) {
            userRepository.setFavoriteRecipe(idRecipe);
        }
    }

}
