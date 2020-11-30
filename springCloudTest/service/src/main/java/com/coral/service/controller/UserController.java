package com.coral.service.controller;

import com.coral.service.pojo.User;
import com.coral.service.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private userService  userService;

    @RequestMapping("/{id}")
    public User show(@PathVariable Long id){
        return userService.selectUser(id);
    }

    @RequestMapping("/add")
    public boolean add(){
        return userService.add();
    }
}
