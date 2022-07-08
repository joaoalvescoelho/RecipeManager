package com.example.recipemanager.Models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "idUsers", nullable = false)
    private Long idUsers;
    private String nameUsers;
    private Long favRecipes;

    public Users() {}

    public Long getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Long idUsers) {
        this.idUsers = idUsers;
    }

    public String getNameUsers() {
        return nameUsers;
    }

    public void setNameUsers(String nameUsers) {
        this.nameUsers = nameUsers;
    }

    public Long getFavRecipes() {
        return favRecipes;
    }

    public void setFavRecipes(Long favRecipes) {
        this.favRecipes = favRecipes;
    }

}
