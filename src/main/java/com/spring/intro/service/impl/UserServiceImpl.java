package com.spring.intro.service.impl;

import com.spring.intro.dao.UserDao;
import com.spring.intro.model.User;
import com.spring.intro.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
