package com.example.Service;

import com.example.Dao.UserDao;
import com.example.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Eric on 3/17/2017.
 */
@Service
public class UserService{

    @Autowired
    private UserDao userDao;

    public Collection<User> getAllUsers(){
        return this.userDao.getAllUsers();
    }

    public User getUserById(int id){
        return this.userDao.getUserById(id);
    }


}
