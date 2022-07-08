package com.example.recipemanager.Models;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredients {

    @Id
    @Column(name = "idIngredients", nullable = false)
    private Long idIngredients;
    private String name;

    public Ingredients() {}

    public Long getIdUsers() {
        return idIngredients;
    }

    public void setIdUsers(Long idIngredients) {
        this.idIngredients = idIngredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameUsers) {
        this.name = nameUsers;
    }
}