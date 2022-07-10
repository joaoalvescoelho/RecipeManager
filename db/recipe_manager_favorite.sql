create table favorite
(
    id_user   int unsigned null,
    id_recipe int unsigned null,
    constraint recipefavorite
        foreign key (id_recipe) references recipes (id_recipe)
            on delete cascade,
    constraint userfavorite
        foreign key (id_user) references users (id_users)
            on delete cascade
);

create index recipefavorite_idx
    on favorite (id_recipe);

create index userfavorite_idx
    on favorite (id_user);

INSERT INTO recipe_manager.favorite (id_user, id_recipe) VALUES (1, 68);
INSERT INTO recipe_manager.favorite (id_user, id_recipe) VALUES (1, 69);
