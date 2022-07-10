package com.example.recipemanager.Controllers;

import com.example.recipemanager.Models.Recipes;
import com.example.recipemanager.Reporting.Recipe;
import com.example.recipemanager.Reporting.SearchRecipe;
import com.example.recipemanager.Services.RecipeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RecipeController.class)
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService mockRecipeService;

    @Test
    void testSearch1() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(get("/searchRecipes")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        
    }

    @Test
    void testSearch2() throws Exception {
        final Recipes recipes = new Recipes();
        recipes.setName("name");
        recipes.setDescription("description");
        recipes.setInstructions("instructions");
        recipes.setServings("servings");
        final SearchRecipe searchRecipe = new SearchRecipe(List.of(recipes));
        when(mockRecipeService.getAllByFields("isVeg", "ingredients", "instructions", "servings",
                "exclude")).thenReturn(searchRecipe);
        final MockHttpServletResponse response = mockMvc.perform(post("/searchResults")
                        .param("veg", "isVeg")
                        .param("ingredients", "ingredients")
                        .param("instructions", "instructions")
                        .param("servings", "servings")
                        .param("excludeIngredients", "exclude")

                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testCreate() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(get("/create")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        
    }

    @Test
    void testCreateRecipe() throws Exception {
        final Recipe recipe = new Recipe("id", "name", "description", "is_vegetarian", "instructions", "servings",
                "ingredients");
        when(mockRecipeService.createRecipe("name", "description", "isVeg", "instructions", "servings",
                "ingredients")).thenReturn(recipe);
        final MockHttpServletResponse response = mockMvc.perform(post("/createRecipes")
                        .param("veg", "isVeg")
                        .param("ingredients", "ingredients")
                        .param("instructions", "instructions")
                        .param("servings", "servings")
                        .param("name", "name")
                        .param("description", "description")

                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testManage() throws Exception {
        final Recipes recipes1 = new Recipes();
        recipes1.setName("name");
        recipes1.setDescription("description");
        recipes1.setInstructions("instructions");
        recipes1.setServings("servings");
        final List<Recipes> recipes = List.of(recipes1);
        when(mockRecipeService.getAllRecipes()).thenReturn(recipes);
        final MockHttpServletResponse response = mockMvc.perform(get("/manageRecipes")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testManage_RecipeServiceReturnsNoItems() throws Exception {
        when(mockRecipeService.getAllRecipes()).thenReturn(Collections.emptyList());
        final MockHttpServletResponse response = mockMvc.perform(get("/manageRecipes")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testUpdateRecipe() throws Exception {
        final Recipe recipe = new Recipe("id", "name", "description", "is_vegetarian", "instructions", "servings",
                "ingredients");
        when(mockRecipeService.getRecipeById("idRecipe")).thenReturn(recipe);
        final MockHttpServletResponse response = mockMvc.perform(post("/updateRecipe/{idRecipe}", "idRecipe")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testUpdate() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(post("/updateRecipes/{id}", "id")
                        .param("newName", "newName")
                        .param("is_vegetarian", "isVeg")
                        .param("instructions", "instructions")
                        .param("servings", "servings")
                        .param("description", "description")
                        .param("ingredients", "ingredients")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        
        verify(mockRecipeService).updateRecipe("newName", "description", "isVeg", "instructions", "servings",
                "ingredients", "id");
    }

    @Test
    void testDeleteRecipe() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(post("/deleteRecipe/{idRecipe}", "idRecipe").accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        
        verify(mockRecipeService).deleteRecipe("idRecipe");
    }

}
