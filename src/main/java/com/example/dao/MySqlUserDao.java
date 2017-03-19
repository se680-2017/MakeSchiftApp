package com.example.dao;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Eric on 3/18/2017.
 */
@Repository("mysql")
public class MySqlUserDao implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class UserRowMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException{
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setFname(resultSet.getString("fname"));
            user.setLname(resultSet.getString("lname"));
            return user;
        }
    }

    @Override
    public Collection<User> getAllUsers(){
        final String sql = "SELECT id, fname, lname FROM user";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
        return users;
    }

    @Override
    public User getUserById(int id){
        return null;
    }

    @Override
    public void removeUserById(int id){

    }

    @Override
    public void updateUser(User user){

    }

    @Override
    public void insertUser(User user){

    }
}
