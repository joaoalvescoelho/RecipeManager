create table recipes
(
    id_recipe     int unsigned auto_increment
        primary key,
    name          varchar(255) not null,
    description   varchar(255) not null,
    is_vegetarian varchar(45)  not null,
    instructions  text         not null,
    servings      varchar(45)  not null,
    constraint idrecipe_UNIQUE
        unique (id_recipe)
);

INSERT INTO recipe_manager.recipes (id_recipe, name, description, is_vegetarian, instructions, servings) VALUES (68, 'Sushi', 'Amazing japanese food with fresh fish', 'n', 'Cook the rice. After wrap the rice and salmon in the algae', '8');
INSERT INTO recipe_manager.recipes (id_recipe, name, description, is_vegetarian, instructions, servings) VALUES (69, 'Toast', '', 'n', '', '1');
