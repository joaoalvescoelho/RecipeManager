create table ingredients
(
    id_ingredients int unsigned auto_increment
        primary key,
    name           varchar(255) not null,
    constraint idingredients_UNIQUE
        unique (id_ingredients)
);

INSERT INTO recipe_manager.ingredients (id_ingredients, name) VALUES (59, 'Rice');
INSERT INTO recipe_manager.ingredients (id_ingredients, name) VALUES (60, 'Salmon');
INSERT INTO recipe_manager.ingredients (id_ingredients, name) VALUES (61, 'Algae');
INSERT INTO recipe_manager.ingredients (id_ingredients, name) VALUES (62, 'Avocado');
INSERT INTO recipe_manager.ingredients (id_ingredients, name) VALUES (63, 'Philadelphia');
INSERT INTO recipe_manager.ingredients (id_ingredients, name) VALUES (64, 'Bread');
