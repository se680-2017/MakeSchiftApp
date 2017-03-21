package com.example.entity;

import javax.persistence.Entity;

/**
 * Created by Eric on 3/17/2017.
 */

public class User{

    private int id;
    private String fname;
    private String lname;
    private String username;
    private String email;
    private String password;

    public User(int id, String fname, String lname,
                String email, String username, String password){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(){}

    public int getId(){
        return id;
    }

    public void setId(int id){

        this.id = id;
    }

    public String getFname(){

        return fname;
    }

    public void setFname(String fname){

        this.fname = fname;
    }

    public String getLname(){

        return lname;
    }

    public void setLname(String lname){

        this.lname = lname;
    }

    public String getEmail(){
        return email;

    }

    public void setEmail(String email){

        this.email = email;
    }

    public String getUsername(){

        return username;
    }

    public void setUsername(String username){

        this.username = username;
    }

    public String getPassword(){

        return password;
    }

    public void setPassword(String password){

        this.password = password;
    }



}
