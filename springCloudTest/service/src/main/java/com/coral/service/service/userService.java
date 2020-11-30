package com.coral.service.service;

import com.coral.service.mapper.UserMapper;
import com.coral.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class userService {
    @Autowired
    private UserMapper userMapper;

    public User selectUser(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public boolean add(){
       User u=new User();
       u.setUsername("2");
       u.setPassword("2");
       int insert = userMapper.insert(u);
       if(insert!=1){
           return false;
       }
        return true;
    }
}
