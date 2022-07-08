package com.example.recipemanager.Repositories;

import com.example.recipemanager.Models.Recipes;
import com.example.recipemanager.Models.Users;
import com.example.recipemanager.Reporting.RecipesName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Users, String> {

    @Query(
            value = "SELECT recipes.name FROM recipes",
            nativeQuery = true
    )
    List<Recipes> queryAll();
}
