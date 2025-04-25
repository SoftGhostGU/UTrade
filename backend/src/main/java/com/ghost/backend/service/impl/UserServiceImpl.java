package com.ghost.backend.service.impl;

import com.ghost.backend.mapper.UserMapper;
import com.ghost.backend.pojo.User;
import com.ghost.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User u = userMapper.findByUsername(username);
        return u;
    }

    @Override
    public void register(String username, String password, String email) {
        // 加密处理
//        String md5String = MD5Utils.string2MD5(password);
        // 添加
        userMapper.add(username, password, email);
    }


}
