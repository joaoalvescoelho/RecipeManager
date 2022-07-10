package com.example.recipemanager.Repositories;

import com.example.recipemanager.Models.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipes, String> {

    @Query(
            value = "SELECT * FROM recipes, ingredients, recipesingredients " +
                    "WHERE ingredients.name LIKE CONCAT('%',?1,'%') AND recipes.is_vegetarian LIKE CONCAT('%',?2,'%') AND recipes.instructions LIKE CONCAT('%',?3,'%') AND recipes.servings LIKE ?4 GROUP BY recipes.id_recipe",
            nativeQuery = true
    )
    List<Recipes> getByInputsWithServings(@Param("?1") String ingredients, @Param("?2") String veg, @Param("?3") String instructions, @Param("?4") String servings);

    @Query(
            value = "SELECT * FROM recipes, ingredients, recipesingredients " +
                    "WHERE recipes.id_recipe = recipesingredients.id_recipes AND ingredients.id_ingredients = recipesingredients.id_ingredients AND " +
                    "ingredients.name LIKE CONCAT('%',?1,'%') AND recipes.is_vegetarian LIKE CONCAT('%',?2,'%') AND recipes.instructions LIKE CONCAT('%',?3,'%') GROUP BY recipes.id_recipe",
            nativeQuery = true
    )
    List<Recipes> getByInputsWithoutServings(@Param("?1") String ingredients, @Param("?2") String veg, @Param("?3") String instructions);

    @Query(
            value = "SELECT * FROM recipes, ingredients, recipesingredients " +
                    "WHERE (NOT ingredients.name LIKE CONCAT('%',?1,'%')) AND recipes.is_vegetarian LIKE CONCAT('%',?2,'%') AND recipes.instructions LIKE CONCAT('%',?3,'%') AND recipes.servings LIKE ?4 GROUP BY recipes.id_recipe",
            nativeQuery = true
    )
    List<Recipes> getByInputsWithServingsAndExcludeIngredients(@Param("?1") String exclude, @Param("?2") String veg, @Param("?3") String instructions, @Param("?4") String servings);

    @Query(
            value = "SELECT * FROM recipes " +
                    "WHERE ( SELECT COUNT(*) FROM recipesingredients WHERE recipesingredients.id_recipes = recipes.id_recipe) = ( SELECT COUNT(*) FROM recipesingredients INNER JOIN ingredients ON ingredients.id_ingredients = recipesingredients.id_ingredients WHERE recipesingredients.id_recipes = recipes.id_recipe AND ingredients.name NOT LIKE CONCAT('%',?1,'%')) " +
                    "AND recipes.is_vegetarian LIKE CONCAT('%',?2,'%') AND recipes.instructions LIKE CONCAT('%',?3,'%');",
            nativeQuery = true
    )
    List<Recipes> getByInputsWithoutServingsAndExcludeIngredients(@Param("?1") String exclude, @Param("?2") String veg, @Param("?3") String instructions);

    @Query(
            value = "SELECT * FROM recipes",
            nativeQuery = true
    )
    List<Recipes> getAllRecipes();

    @Modifying
    @Query(
            value = "INSERT INTO recipes (recipes.name, recipes.description, recipes.is_vegetarian, recipes.instructions, recipes.servings) VALUES (?1, ?2, ?3, ?4, ?5);",
            nativeQuery = true
    )
    @Transactional
    void createRecipe(@Param("?1") String name, @Param("?2") String description, @Param("?3") String isVeg, @Param("?4") String instructions, @Param("?5") String servings);

    @Query(
            value = "SELECT * FROM recipes ORDER BY recipes.id_recipe DESC LIMIT 1",
            nativeQuery = true
    )
    Recipes lastRecipe();

    @Modifying
    @Query(
            value = "INSERT INTO ingredients (ingredients.name) VALUES (?1);",
            nativeQuery = true
    )
    @Transactional
    void createIngredient(@Param("?1") String ingredient);

    @Modifying
    @Query(
            value = "INSERT INTO recipesingredients (recipesingredients.id_recipes, recipesingredients.id_ingredients) VALUES ((SELECT recipes.id_recipe FROM recipes WHERE recipes.id_recipe LIKE ?1 ), " +
                    "(SELECT ingredients.id_ingredients FROM ingredients WHERE ingredients.name LIKE ?2));",
            nativeQuery = true
    )
    @Transactional
    void createRecipeIngredients(@Param("?1") String id, @Param("?2") String ingredient);

    @Query(
            value = "SELECT * FROM recipes WHERE recipes.name = ?1",
            nativeQuery = true
    )
    Recipes findByName(String name);

    @Query(
            value = "SELECT ingredients.name FROM ingredients, recipesingredients WHERE recipesingredients.id_ingredients = ingredients.id_ingredients AND recipesingredients.id_recipes = ?1 ",
            nativeQuery = true
    )
    List<String> findIngredientByRecipeId(Long id);

    @Modifying
    @Query(
            value = "DELETE FROM recipes WHERE recipes.id_recipe LIKE ?1",
            nativeQuery = true
    )
    @Transactional
    void delete(String idRecipe);

    @Query(
            value = "SELECT * FROM recipes WHERE recipes.id_recipe = ?1",
            nativeQuery = true
    )
    Recipes findRecipeById(String idRecipe);

    @Query(
            value = "SELECT ingredients.name FROM ingredients WHERE ingredients.name = ?1 ",
            nativeQuery = true
    )
    String findIngredientByName(String ingredient);

    @Query(
            value = "SELECT ingredients.name, ingredients.id_ingredients FROM ingredients, recipesingredients WHERE recipesingredients.id_ingredients = ingredients.id_ingredients AND recipesingredients.id_recipes = ?1",
            nativeQuery = true
    )
    Object[] findIngredientList(Long idRecipe);

    @Modifying
    @Query(
            value = "DELETE FROM recipesingredients WHERE recipesingredients.id_recipes LIKE ?1",
            nativeQuery = true
    )
    @Transactional
    void deleteIngredientsRecipeRelationsById(Long relationId);
}
