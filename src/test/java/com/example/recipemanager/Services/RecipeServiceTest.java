package com.example.recipemanager.Services;

import com.example.recipemanager.Models.Recipes;
import com.example.recipemanager.Reporting.Recipe;
import com.example.recipemanager.Reporting.SearchRecipe;
import com.example.recipemanager.Repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock
    private RecipeRepository mockRecipeRepository;

    @InjectMocks
    private RecipeService recipeServiceUnderTest;

    @Test
    void testGetAllByFields() {
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        final List<Recipes> recipes = List.of(recipes1);
        lenient().when(mockRecipeRepository.getByInputsWithoutServingsAndExcludeIngredients("exclude", "veg",
                "instructions")).thenReturn(recipes);
        final Recipes recipes3 = new Recipes();
        recipes3.setName("name");
        recipes3.setDescription("description");
        recipes3.setInstructions("instructions");
        recipes3.setServings("servings");
        final List<Recipes> recipes2 = List.of(recipes3);
        lenient().when(mockRecipeRepository.getByInputsWithServingsAndExcludeIngredients("exclude", "veg", "instructions",
                "servings")).thenReturn(recipes2);
        final Recipes recipes5 = new Recipes();
        recipes5.setName("name");
        recipes5.setDescription("description");
        recipes5.setInstructions("instructions");
        recipes5.setServings("servings");
        final List<Recipes> recipes4 = List.of(recipes5);
        lenient().when(mockRecipeRepository.getByInputsWithoutServings("ingredients", "veg", "instructions"))
                .thenReturn(recipes4);
        final Recipes recipes7 = new Recipes();
        recipes7.setName("name");
        recipes7.setDescription("description");
        recipes7.setInstructions("instructions");
        recipes7.setServings("servings");
        final List<Recipes> recipes6 = List.of(recipes7);
        lenient().when(mockRecipeRepository.getByInputsWithServings("ingredients", "veg", "instructions", "servings"))
                .thenReturn(recipes6);
        final Recipes recipes9 = new Recipes();
        recipes9.setName("name");
        recipes9.setDescription("description");
        recipes9.setInstructions("instructions");
        recipes9.setServings("servings");
        final List<Recipes> recipes8 = List.of(recipes9);
        lenient().when(mockRecipeRepository.getAllRecipes()).thenReturn(recipes8);
        final SearchRecipe result = recipeServiceUnderTest.getAllByFields("veg", "ingredients", "instructions",
                "servings", "exclude");
    }

    @Test
    void testGetAllByFields_RecipeRepositoryGetByInputsWithoutServingsAndExcludeIngredientsReturnsNoItems() {
        lenient().when(mockRecipeRepository.getByInputsWithoutServingsAndExcludeIngredients("exclude", "veg",
                "instructions")).thenReturn(Collections.emptyList());
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        final List<Recipes> recipes = List.of(recipes1);
        lenient().when(mockRecipeRepository.getByInputsWithServingsAndExcludeIngredients("exclude", "veg", "instructions",
                "servings")).thenReturn(recipes);
        final Recipes recipes3 = new Recipes();
        recipes3.setName("name");
        recipes3.setDescription("description");
        recipes3.setInstructions("instructions");
        recipes3.setServings("servings");
        final List<Recipes> recipes2 = List.of(recipes3);
        lenient().when(mockRecipeRepository.getByInputsWithoutServings("ingredients", "veg", "instructions"))
                .thenReturn(recipes2);
        final Recipes recipes5 = new Recipes();
        recipes5.setName("name");
        recipes5.setDescription("description");
        recipes5.setInstructions("instructions");
        recipes5.setServings("servings");
        final List<Recipes> recipes4 = List.of(recipes5);
        lenient().when(mockRecipeRepository.getByInputsWithServings("ingredients", "veg", "instructions", "servings"))
                .thenReturn(recipes4);
        final Recipes recipes7 = new Recipes();
        recipes7.setName("name");
        recipes7.setDescription("description");
        recipes7.setInstructions("instructions");
        recipes7.setServings("servings");
        final List<Recipes> recipes6 = List.of(recipes7);
        lenient().when(mockRecipeRepository.getAllRecipes()).thenReturn(recipes6);
        final SearchRecipe result = recipeServiceUnderTest.getAllByFields("veg", "ingredients", "instructions",
                "servings", "exclude");
    }

    @Test
    void testGetAllByFields_RecipeRepositoryGetByInputsWithServingsAndExcludeIngredientsReturnsNoItems() {
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        final List<Recipes> recipes = List.of(recipes1);
        lenient().when(mockRecipeRepository.getByInputsWithoutServingsAndExcludeIngredients("exclude", "veg",
                "instructions")).thenReturn(recipes);

        lenient().when(mockRecipeRepository.getByInputsWithServingsAndExcludeIngredients("exclude", "veg", "instructions",
                "servings")).thenReturn(Collections.emptyList());
        final Recipes recipes3 = new Recipes();
        recipes3.setName("name");
        recipes3.setDescription("description");
        recipes3.setInstructions("instructions");
        recipes3.setServings("servings");
        final List<Recipes> recipes2 = List.of(recipes3);
        lenient().when(mockRecipeRepository.getByInputsWithoutServings("ingredients", "veg", "instructions"))
                .thenReturn(recipes2);
        final Recipes recipes5 = new Recipes();
        recipes5.setName("name");
        recipes5.setDescription("description");
        recipes5.setInstructions("instructions");
        recipes5.setServings("servings");
        final List<Recipes> recipes4 = List.of(recipes5);
        lenient().when(mockRecipeRepository.getByInputsWithServings("ingredients", "veg", "instructions", "servings"))
                .thenReturn(recipes4);
        final Recipes recipes7 = new Recipes();
        recipes7.setName("name");
        recipes7.setDescription("description");
        recipes7.setInstructions("instructions");
        recipes7.setServings("servings");
        final List<Recipes> recipes6 = List.of(recipes7);
        lenient().when(mockRecipeRepository.getAllRecipes()).thenReturn(recipes6);
        final SearchRecipe result = recipeServiceUnderTest.getAllByFields("veg", "ingredients", "instructions",
                "servings", "exclude");
    }

    @Test
    void testGetAllByFields_RecipeRepositoryGetByInputsWithoutServingsReturnsNoItems() {
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        final List<Recipes> recipes = List.of(recipes1);
        lenient().when(mockRecipeRepository.getByInputsWithoutServingsAndExcludeIngredients("exclude", "veg",
                "instructions")).thenReturn(recipes);
        final Recipes recipes3 = new Recipes();
        recipes3.setName("name");
        recipes3.setDescription("description");
        recipes3.setInstructions("instructions");
        recipes3.setServings("servings");
        final List<Recipes> recipes2 = List.of(recipes3);
        lenient().when(mockRecipeRepository.getByInputsWithServingsAndExcludeIngredients("exclude", "veg", "instructions",
                "servings")).thenReturn(recipes2);
        lenient().when(mockRecipeRepository.getByInputsWithoutServings("ingredients", "veg", "instructions"))
                .thenReturn(Collections.emptyList());
        final Recipes recipes5 = new Recipes();
        recipes5.setName("name");
        recipes5.setDescription("description");
        recipes5.setInstructions("instructions");
        recipes5.setServings("servings");
        final List<Recipes> recipes4 = List.of(recipes5);
        lenient().when(mockRecipeRepository.getByInputsWithServings("ingredients", "veg", "instructions", "servings"))
                .thenReturn(recipes4);
        final Recipes recipes7 = new Recipes();
        recipes7.setName("name");
        recipes7.setDescription("description");
        recipes7.setInstructions("instructions");
        recipes7.setServings("servings");
        final List<Recipes> recipes6 = List.of(recipes7);
        lenient().when(mockRecipeRepository.getAllRecipes()).thenReturn(recipes6);
        final SearchRecipe result = recipeServiceUnderTest.getAllByFields("veg", "ingredients", "instructions",
                "servings", "exclude");
    }

    @Test
    void testGetAllByFields_RecipeRepositoryGetByInputsWithServingsReturnsNoItems() {
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        final List<Recipes> recipes = List.of(recipes1);
        lenient().when(mockRecipeRepository.getByInputsWithoutServingsAndExcludeIngredients("exclude", "veg",
                "instructions")).thenReturn(recipes);
        final Recipes recipes3 = new Recipes();
        recipes3.setName("name");
        recipes3.setDescription("description");
        recipes3.setInstructions("instructions");
        recipes3.setServings("servings");
        final List<Recipes> recipes2 = List.of(recipes3);
        lenient().when(mockRecipeRepository.getByInputsWithServingsAndExcludeIngredients("exclude", "veg", "instructions",
                "servings")).thenReturn(recipes2);
        final Recipes recipes5 = new Recipes();
        recipes5.setName("name");
        recipes5.setDescription("description");
        recipes5.setInstructions("instructions");
        recipes5.setServings("servings");
        final List<Recipes> recipes4 = List.of(recipes5);
        lenient().when(mockRecipeRepository.getByInputsWithoutServings("ingredients", "veg", "instructions"))
                .thenReturn(recipes4);
        lenient().when(mockRecipeRepository.getByInputsWithServings("ingredients", "veg", "instructions", "servings"))
                .thenReturn(Collections.emptyList());
        final Recipes recipes7 = new Recipes();
        recipes7.setName("name");
        recipes7.setDescription("description");
        recipes7.setInstructions("instructions");
        recipes7.setServings("servings");
        final List<Recipes> recipes6 = List.of(recipes7);
        lenient().when(mockRecipeRepository.getAllRecipes()).thenReturn(recipes6);
        final SearchRecipe result = recipeServiceUnderTest.getAllByFields("veg", "ingredients", "instructions",
                "servings", "exclude");
    }

    @Test
    void testGetAllByFields_RecipeRepositoryGetAllRecipesReturnsNoItems() {
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        final List<Recipes> recipes = List.of(recipes1);
        lenient().when(mockRecipeRepository.getByInputsWithoutServingsAndExcludeIngredients("exclude", "veg",
                "instructions")).thenReturn(recipes);
        final Recipes recipes3 = new Recipes();
        recipes3.setName("name");
        recipes3.setDescription("description");
        recipes3.setInstructions("instructions");
        recipes3.setServings("servings");
        final List<Recipes> recipes2 = List.of(recipes3);
        lenient().when(mockRecipeRepository.getByInputsWithServingsAndExcludeIngredients("exclude", "veg", "instructions",
                "servings")).thenReturn(recipes2);
        final Recipes recipes5 = new Recipes();
        recipes5.setName("name");
        recipes5.setDescription("description");
        recipes5.setInstructions("instructions");
        recipes5.setServings("servings");
        final List<Recipes> recipes4 = List.of(recipes5);
        lenient().when(mockRecipeRepository.getByInputsWithoutServings("ingredients", "veg", "instructions"))
                .thenReturn(recipes4);
        final Recipes recipes7 = new Recipes();
        recipes7.setName("name");
        recipes7.setDescription("description");
        recipes7.setInstructions("instructions");
        recipes7.setServings("servings");
        final List<Recipes> recipes6 = List.of(recipes7);
        lenient().when(mockRecipeRepository.getByInputsWithServings("ingredients", "veg", "instructions", "servings"))
                .thenReturn(recipes6);
        lenient().when(mockRecipeRepository.getAllRecipes()).thenReturn(Collections.emptyList());
        final SearchRecipe result = recipeServiceUnderTest.getAllByFields("veg", "ingredients", "instructions",
                "servings", "exclude");
    }

    @Test
    void testCreateRecipe() {
        final Recipes recipes = new Recipes();
        recipes.setName("name");
        recipes.setDescription("description");
        recipes.setInstructions("instructions");
        recipes.setServings("servings");
        lenient().when(mockRecipeRepository.lastRecipe()).thenReturn(recipes);
        lenient().when(mockRecipeRepository.findIngredientByName("ingredient")).thenReturn("result");
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        lenient().when(mockRecipeRepository.findByName("name")).thenReturn(recipes1);
        lenient().when(mockRecipeRepository.findIngredientByRecipeId(0L)).thenReturn(List.of("value"));
        recipeServiceUnderTest.createRecipe("name", "description", "isVeg", "instructions",
                "servings", "ingredients");
        verify(mockRecipeRepository).createRecipe("name", "description", "isVeg", "instructions", "servings");
        verify(mockRecipeRepository).createIngredient("ingredient");
        verify(mockRecipeRepository).createRecipeIngredients("id", "ingredient");
    }

    @Test
    void testCreateRecipe_RecipeRepositoryFindIngredientByNameReturnsNull() {
        final Recipes recipes = new Recipes();
        recipes.setName("name");
        recipes.setDescription("description");
        recipes.setInstructions("instructions");
        recipes.setServings("servings");
        lenient().when(mockRecipeRepository.lastRecipe()).thenReturn(recipes);
        lenient().when(mockRecipeRepository.findIngredientByName("ingredient")).thenReturn(null);
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        lenient().when(mockRecipeRepository.findByName("name")).thenReturn(recipes1);
        lenient().when(mockRecipeRepository.findIngredientByRecipeId(0L)).thenReturn(List.of("value"));
        final Recipe result = recipeServiceUnderTest.createRecipe("name", "description", "isVeg", "instructions",
                "servings", "ingredients");
        verify(mockRecipeRepository).createRecipe("name", "description", "isVeg", "instructions", "servings");
        verify(mockRecipeRepository).createIngredient("ingredient");
        verify(mockRecipeRepository).createRecipeIngredients("id", "ingredient");
    }

    @Test
    void testCreateRecipe_RecipeRepositoryFindIngredientByRecipeIdReturnsNoItems() {
        final Recipes recipes = new Recipes();
        recipes.setName("name");
        recipes.setDescription("description");
        recipes.setInstructions("instructions");
        recipes.setServings("servings");
        lenient().when(mockRecipeRepository.lastRecipe()).thenReturn(recipes);
        lenient().when(mockRecipeRepository.findIngredientByName("ingredient")).thenReturn("result");
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        lenient().when(mockRecipeRepository.findByName("name")).thenReturn(recipes1);
        lenient().when(mockRecipeRepository.findIngredientByRecipeId(0L)).thenReturn(Collections.emptyList());
        final Recipe result = recipeServiceUnderTest.createRecipe("name", "description", "isVeg", "instructions",
                "servings", "ingredients");
        verify(mockRecipeRepository).createRecipe("name", "description", "isVeg", "instructions", "servings");
        verify(mockRecipeRepository).createIngredient("ingredient");
        verify(mockRecipeRepository).createRecipeIngredients("id", "ingredient");
    }

    @Test
    void testGetAllRecipes() {
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        final List<Recipes> recipes = List.of(recipes1);
        lenient().when(mockRecipeRepository.findAll()).thenReturn(recipes);
        final List<Recipes> result = recipeServiceUnderTest.getAllRecipes();
    }

    @Test
    void testGetAllRecipes_RecipeRepositoryReturnsNoItems() {
        lenient().when(mockRecipeRepository.findAll()).thenReturn(Collections.emptyList());
        final List<Recipes> result = recipeServiceUnderTest.getAllRecipes();
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetRecipeById() {
        final Recipes recipes = new Recipes();
        recipes.setName("name");
        recipes.setDescription("description");
        recipes.setInstructions("instructions");
        recipes.setServings("servings");
        lenient().when(mockRecipeRepository.findRecipeById("idRecipe")).thenReturn(recipes);
        lenient().when(mockRecipeRepository.findIngredientByRecipeId(0L)).thenReturn(List.of("value"));
        final Recipe result = recipeServiceUnderTest.getRecipeById("idRecipe");
    }

    @Test
    void testGetRecipeById_RecipeRepositoryFindIngredientByRecipeIdReturnsNoItems() {
        final Recipes recipes = new Recipes();
        recipes.setName("name");
        recipes.setDescription("description");
        recipes.setInstructions("instructions");
        recipes.setServings("servings");
        lenient().when(mockRecipeRepository.findRecipeById("idRecipe")).thenReturn(recipes);
        lenient().when(mockRecipeRepository.findIngredientByRecipeId(0L)).thenReturn(Collections.emptyList());
        final Recipe result = recipeServiceUnderTest.getRecipeById("idRecipe");
    }

    @Test
    void testUpdateRecipe() {
        final Recipes recipes = new Recipes();
        recipes.setName("name");
        recipes.setDescription("description");
        recipes.setInstructions("instructions");
        recipes.setServings("servings");
        lenient().when(mockRecipeRepository.findRecipeById("idRecipe")).thenReturn(recipes);
        lenient().when(mockRecipeRepository.findIngredientByName("ingredient")).thenReturn("result");
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        lenient().when(mockRecipeRepository.save(any(Recipes.class))).thenReturn(recipes1);
        recipeServiceUnderTest.updateRecipe("name", "description", "vegetarian", "instructions", "servings",
                "ingredients", "idRecipe");
        verify(mockRecipeRepository).deleteIngredientsRecipeRelationsById(0L);
        verify(mockRecipeRepository).createIngredient("ingredient");
        verify(mockRecipeRepository).createRecipeIngredients("id", "ingredient");
        verify(mockRecipeRepository).save(any(Recipes.class));
    }

    @Test
    void testUpdateRecipe_RecipeRepositoryFindIngredientByNameReturnsNull() {
        final Recipes recipes = new Recipes();
        recipes.setName("name");
        recipes.setDescription("description");
        recipes.setInstructions("instructions");
        recipes.setServings("servings");
        lenient().when(mockRecipeRepository.findRecipeById("idRecipe")).thenReturn(recipes);
        lenient().when(mockRecipeRepository.findIngredientByName("ingredient")).thenReturn(null);
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        lenient().when(mockRecipeRepository.save(any(Recipes.class))).thenReturn(recipes1);
        recipeServiceUnderTest.updateRecipe("name", "description", "vegetarian", "instructions", "servings",
                "ingredients", "idRecipe");
        verify(mockRecipeRepository).deleteIngredientsRecipeRelationsById(0L);
        verify(mockRecipeRepository).createIngredient("ingredient");
        verify(mockRecipeRepository).createRecipeIngredients("id", "ingredient");
        verify(mockRecipeRepository).save(any(Recipes.class));
    }

    @Test
    void testDeleteRecipe() {
        recipeServiceUnderTest.deleteRecipe("idRecipe");
        verify(mockRecipeRepository).delete("idRecipe");
    }
}
