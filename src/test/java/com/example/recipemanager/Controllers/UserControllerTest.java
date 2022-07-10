package com.example.recipemanager.Controllers;

import com.example.recipemanager.Reporting.FavRecipes;
import com.example.recipemanager.Services.RecipeService;
import com.example.recipemanager.Services.UserService;
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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService mockUserService;
    @MockBean
    private RecipeService mockRecipeService;

    @Test
    void testFavorite() throws Exception {
        when(mockUserService.getFavRecipes()).thenReturn(new FavRecipes(List.of()));
        final MockHttpServletResponse response = mockMvc.perform(get("/favoriteRecipes")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    void testMakeFavorite() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(get("/makeFavorite/{idRecipe}", "idRecipe")
                        .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockUserService).setFavoriteRecipe("idRecipe");
    }
}
