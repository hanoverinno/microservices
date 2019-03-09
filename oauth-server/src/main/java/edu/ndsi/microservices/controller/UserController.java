package edu.ndsi.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ndsi.microservices.model.User;
import edu.ndsi.microservices.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listUser(){
        return userService.findAll();
    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public User create(@RequestBody User user){
//        return userService.save(user);
//    }
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable(value = "id") Long id){
//        userService.delete(id);
//        return "success";
//    }

}