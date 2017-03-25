package com.example.Dao;

import com.example.Entity.User;

import java.util.Collection;

/**
 * Created by Eric on 3/18/2017.
 */
public interface UserDao{
    Collection<User> getAllUsers();

    User getUserById(int id);

    void removeUserById(int id);

    void updateUser(User user);

    void insertUser(User user);
}
