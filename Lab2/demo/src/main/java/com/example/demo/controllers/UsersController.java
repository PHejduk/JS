package com.example.demo.controllers;

import com.example.demo.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {
    private Map<Integer, UserEntity> users;
    private int iterator = 0;
    public UsersController() {
        this.users = new HashMap<>();
        this.users.put(this.iterator, new UserEntity(18, "Jan"));
        this.iterator++;
        this.users.put(this.iterator, new UserEntity(21, "Pawel"));
        this.iterator++;
        this.users.put(this.iterator, new UserEntity(66, "Robert"));
        this.iterator++;

    }

    @RequestMapping("/users")
    @ResponseBody
    public Object getUsers() {
        return this.users;
    }

    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public Object getUsers(@PathVariable int id) {
        return this.users.get(id);
    }


    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public Object removeUsers(@PathVariable int id) {
        this.users.remove(id);
        return "User removed";
    }
    @RequestMapping("/users/add")
    @ResponseBody
    public Object addUser(@RequestParam int age, @RequestParam String name) {
        UserEntity user = new UserEntity(age, name);
        this.users.put(this.iterator, user);
        this.iterator++;
        return "User added";
    }
}
