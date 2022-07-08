package com.example.recipemanager.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipesingredients")
public class RecipeIngredients {

    @Id
    @Column(name = "idIngredients", nullable = false)
    private Long idIngredients;
    private Long idRecipe;

    public RecipeIngredients() {}

    public Long getIdIngredients() {
        return idIngredients;
    }

    public void setIdIngredients(Long idIngredients) {
        this.idIngredients = idIngredients;
    }

    public Long getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(Long idRecipe) {
        this.idRecipe = idRecipe;
    }
}
