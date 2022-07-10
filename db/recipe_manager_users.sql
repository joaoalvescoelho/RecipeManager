create table users
(
    id_users    int unsigned auto_increment
        primary key,
    name        varchar(45) null,
    fav_recipes bigint      null,
    constraint id_users_UNIQUE
        unique (id_users)
);

INSERT INTO recipe_manager.users (id_users, name, fav_recipes) VALUES (1, 'Joao', null);
