package com.example.dao;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
            user.setFname(resultSet.getString("first_name"));
            user.setLname(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }

    @Override
    public Collection<User> getAllUsers(){
        final String sql = "SELECT id, first_name, last_name, email, username, password FROM user";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
        return users;
    }

    @Override
    public User getUserById(int id){
        final String sql = "SELECT id, first_name, last_name, username, email, password FROM user WHERE id = ?";
        //takes in the id desired to delete, passed in from getUserById
        User users = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        return users;
    }

    @Override
    public void removeUserById(int id){
        final String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateUser(User user){
        final String sql = "UPDATE user SET username = ?, password = ? WHERE id = ?";
        final int id = user.getId();
//        final String fname = user.getFname();
//        final String lname = user.getLname();
        final String email = user.getEmail();
        final String username = user.getUsername();
        final String password = user.getPassword();
        jdbcTemplate.update(sql, new Object[] {email, username, password, id});
    }

    @Override
    public void insertUser(User user){
        final String sql = "INSERT INTO user (first_name, last_name, email, username, password) VALUES (?, ?, ?, ?, ?)";
        final String fname = user.getFname();
        final String lname = user.getLname();
        final String email = user.getEmail();
        final String username = user.getUsername();
        //bcrypt provides the salt and hash needed for the pwd
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        final String password = bCrypt.encode(user.getPassword());

        jdbcTemplate.update(sql, new Object[] {fname, lname, email, username, password});

    }
}
