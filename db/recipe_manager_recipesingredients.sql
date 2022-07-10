create table recipesingredients
(
    id_recipes     int unsigned null,
    id_ingredients int unsigned null,
    constraint id_igredients
        foreign key (id_ingredients) references ingredients (id_ingredients)
            on delete cascade,
    constraint id_recipes
        foreign key (id_recipes) references recipes (id_recipe)
            on delete cascade
);

create index id_igredients_idx
    on recipesingredients (id_ingredients);

create index id_recipes_idx
    on recipesingredients (id_recipes);

INSERT INTO recipe_manager.recipesingredients (id_recipes, id_ingredients) VALUES (68, 59);
INSERT INTO recipe_manager.recipesingredients (id_recipes, id_ingredients) VALUES (68, 60);
INSERT INTO recipe_manager.recipesingredients (id_recipes, id_ingredients) VALUES (68, 61);
INSERT INTO recipe_manager.recipesingredients (id_recipes, id_ingredients) VALUES (68, 62);
INSERT INTO recipe_manager.recipesingredients (id_recipes, id_ingredients) VALUES (68, 63);
INSERT INTO recipe_manager.recipesingredients (id_recipes, id_ingredients) VALUES (69, 64);
INSERT INTO recipe_manager.recipesingredients (id_recipes, id_ingredients) VALUES (69, 62);
