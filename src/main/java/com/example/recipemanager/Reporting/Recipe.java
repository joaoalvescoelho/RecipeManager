package com.example.recipemanager.Reporting;

public class Recipe {

    private String id;
    private String name;
    private String description;
    private String is_vegetarian;
    private String instructions;
    private String ingredients;
    private String servings;

    public Recipe(String id, String name, String description, String is_vegetarian, String instructions, String servings, String ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.is_vegetarian = is_vegetarian;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.servings = servings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIs_vegetarian() {
        return is_vegetarian;
    }

    public void setIs_vegetarian(String is_vegetarian) {
        this.is_vegetarian = is_vegetarian;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
