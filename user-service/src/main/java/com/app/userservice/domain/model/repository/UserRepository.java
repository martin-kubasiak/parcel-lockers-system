package com.app.userservice.domain.model.repository;

import com.app.userservice.domain.model.User;
import com.app.userservice.domain.model.UserId;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(UserId id);
    User save(User user);
}
