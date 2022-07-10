package com.example.recipemanager.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    private Users usersUnderTest;

    @BeforeEach
    void setUp() {
        usersUnderTest = new Users();
    }

    @Test
    void testGetIdUsers() {
        assertThat(usersUnderTest.getIdUsers()).isEqualTo(0L);
    }

    @Test
    void testSetIdUsers() {
        usersUnderTest.setIdUsers(0L);
    }
}
