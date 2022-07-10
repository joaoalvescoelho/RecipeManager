package com.example.recipemanager.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "recipe_manager")
public class Users {
    @Id
    private Long id_users;
    private String name;
    private Long favRecipes;

    public Users() {}

    public Long getIdUsers() {
        return id_users;
    }

    public void setIdUsers(Long id_users) {
        this.id_users = id_users;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Long getFavRecipes() {
        return favRecipes;
    }

    public void setFavRecipes(Long favRecipes) {
        this.favRecipes = favRecipes;
    }

}
