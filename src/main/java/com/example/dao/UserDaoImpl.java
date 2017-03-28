package com.example.Dao;

import com.example.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Eric on 3/17/2017.
 */
@Repository
public class UserDaoImpl implements UserDao{

    private static Map<Integer, User> users;

    /*
    static {
        users = new HashMap<Integer, User>(){
            {
                put(1, new User(1, "eric", "tapia"));
                put(2, new User(2, "warren", "kaye"));
                put(3, new User(3, "hazim", "rekab"));
            }
        };
    }
    */

    @Override
    public Collection<User> getAllUsers(){
        return this.users.values();
    }

    @Override
    public User getUserById(int id){

        return this.users.get(id);
    }

    @Override
    public void removeUserById(int id){

        this.users.remove(id);
    }

    @Override
    public void updateUser(User user){
        User n_user = users.get(user.getId());

        n_user.setFname(user.getFname());
        n_user.setLname(user.getLname());

        users.put(user.getId(), user);
    }

    @Override
    public void insertUser(User user){

        this.users.put(user.getId(), user);
    }
}
