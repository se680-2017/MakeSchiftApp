package com.example.Dao;

import com.example.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eric on 3/17/2017.
 */
@Repository
public class UserDao{

    private static Map<Integer, User> users;

    static {
        users = new HashMap<Integer, User>(){
            {
                put(1, new User(1, "eric", "tapia"));
                put(2, new User(2, "warren", "kaye"));
                put(3, new User(3, "hazim", "rekab"));
            }
        };
    }

    public Collection<User> getAllUsers(){
        return this.users.values();
    }

    public User getUserById(int id){
        return this.users.get(id);
    }


}
