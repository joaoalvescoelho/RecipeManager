package com.example.recipemanager.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IngredientsTest {

    private Ingredients ingredientsUnderTest;

    @BeforeEach
    void setUp() {
        ingredientsUnderTest = new Ingredients();
    }

    @Test
    void testGetIdIngredients() {
        assertThat(ingredientsUnderTest.getIdIngredients()).isEqualTo(0L);
    }

    @Test
    void testSetIdIngredients() {
        ingredientsUnderTest.setIdIngredients(0L);
    }
}
