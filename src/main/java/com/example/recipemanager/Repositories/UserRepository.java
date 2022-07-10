package com.example.recipemanager.Repositories;

import com.example.recipemanager.Models.Users;
import com.example.recipemanager.Reporting.RecipesName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, String> {

    @Query(
            value = "SELECT recipes.name FROM recipes, users, favorite WHERE users.id_users = favorite.id_user AND recipes.id_recipe = favorite.id_recipe",
            nativeQuery = true
    )
    List<RecipesName> queryFavRecipes();

    @Modifying
    @Query(
            value = "INSERT INTO favorite (favorite.id_user, favorite.id_recipe) VALUES ((SELECT users.id_users FROM users), " +
                    "(SELECT recipes.id_recipe FROM recipes WHERE recipes.id_recipe LIKE ?1))",
            nativeQuery = true
    )
    @Transactional
    void setFavoriteRecipe(String idRecipe);

    @Query(
            value = "SELECT favorite.id_recipe FROM favorite, users WHERE favorite.id_recipe LIKE ?1 AND favorite.id_user LIKE users.id_users ",
            nativeQuery = true
    )
    List<Integer> findFavoriteById(String idRecipe);
}
