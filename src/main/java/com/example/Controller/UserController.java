package com.example.Controller;

import com.example.Entity.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Eric on 3/17/2017.
 */
@Controller
//@RestController
//@RequestMapping("/register")
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("register", new User());
        return "register";
    }



    //Don't know if we'll need to get all users at some point,
    //but i'll keep it for now.
    /*@RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers(){

        return this.userService.getAllUsers();
    }*/

    @RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
    public User getUserById (@PathVariable("id") int id){

        return userService.getUserById(id);
    }

    @RequestMapping(value = "/cancelaccount/{id}", method = RequestMethod.DELETE)
    public void deleteUserById (@PathVariable("id") int id){

        userService.removeUserById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user){

        userService.updateUser(user);
    }

//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void insertUser(@RequestBody User user){
//        userService.insertUser(user);
//    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String insertUser(@ModelAttribute User user){
        userService.insertUser(user);
        return "home";
    }
}
