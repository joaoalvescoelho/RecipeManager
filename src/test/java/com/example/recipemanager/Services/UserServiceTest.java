package com.example.recipemanager.Services;

import com.example.recipemanager.Reporting.FavRecipes;
import com.example.recipemanager.Repositories.RecipeRepository;
import com.example.recipemanager.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RecipeRepository mockRecipeRepository;

    @InjectMocks
    private UserService userServiceUnderTest;

    @Test
    void testGetFavRecipes() {
        when(mockUserRepository.queryFavRecipes()).thenReturn(List.of());
        final FavRecipes result = userServiceUnderTest.getFavRecipes();
    }

    @Test
    void testGetFavRecipes_UserRepositoryReturnsNoItems() {
        when(mockUserRepository.queryFavRecipes()).thenReturn(Collections.emptyList());
        final FavRecipes result = userServiceUnderTest.getFavRecipes();
    }

    @Test
    void testSetFavoriteRecipe() {
        when(mockUserRepository.findFavoriteById("idRecipe")).thenReturn(List.of(0));
        userServiceUnderTest.setFavoriteRecipe("idRecipe");

        verify(mockUserRepository).setFavoriteRecipe("idRecipe");
    }

    @Test
    void testSetFavoriteRecipe_UserRepositoryFindFavoriteByIdReturnsNoItems() {
        when(mockUserRepository.findFavoriteById("idRecipe")).thenReturn(Collections.emptyList());
        userServiceUnderTest.setFavoriteRecipe("idRecipe");

        verify(mockUserRepository).setFavoriteRecipe("idRecipe");
    }
}
