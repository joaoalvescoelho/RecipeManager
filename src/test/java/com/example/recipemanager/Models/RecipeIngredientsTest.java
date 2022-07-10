package com.example.recipemanager.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeIngredientsTest {

    private RecipeIngredients recipeIngredientsUnderTest;

    @BeforeEach
    void setUp() {
        recipeIngredientsUnderTest = new RecipeIngredients();
    }

    @Test
    void testGetIdIngredients() {
        assertThat(recipeIngredientsUnderTest.getIdIngredients()).isEqualTo(0L);
    }

    @Test
    void testSetIdIngredients() {
        recipeIngredientsUnderTest.setIdIngredients(0L);
    }

    @Test
    void testGetIdRecipe() {
        assertThat(recipeIngredientsUnderTest.getIdRecipe()).isEqualTo(0L);
    }

    @Test
    void testSetIdRecipe() {
        recipeIngredientsUnderTest.setIdRecipe(0L);
    }
}
