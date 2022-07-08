package com.example.recipemanager.Repositories;

import com.example.recipemanager.Models.Users;
import com.example.recipemanager.Reporting.RecipesName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, List> {

    @Query(
            value = "SELECT recipes.name FROM recipes, users WHERE users.favRecipes = recipes.idRecipe",
            nativeQuery = true
    )
    List<RecipesName> queryFavRecipes();
}
