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
}
