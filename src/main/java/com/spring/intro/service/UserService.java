package com.spring.intro.service;

import com.spring.intro.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long id);
}
