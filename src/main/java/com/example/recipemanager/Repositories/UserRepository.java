package com.example.recipemanager.Repositories;

import org.springframework.data.jpa.repository.Query;

public interface UserRepository {

    @Query(
            value = "SELECT * FROM users u WHERE "
    )
}
