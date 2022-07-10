package com.example.recipemanager.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecipesTest {

    private Recipes recipesUnderTest;

    @BeforeEach
    void setUp() {
        recipesUnderTest = new Recipes();
    }

    @Test
    void testGetIdRecipe() {
        assertThat(recipesUnderTest.getIdRecipe()).isEqualTo(0L);
    }

    @Test
    void testSetIdRecipe() {
        recipesUnderTest.setIdRecipe(0L);
    }

    @Test
    void testIsVegetarian() {
        assertThat(recipesUnderTest.isVegetarian()).isEqualTo("vegetarian");
    }

    @Test
    void testSetVegetarian() {
        recipesUnderTest.setVegetarian("vegetarian");
    }
}
