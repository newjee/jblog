package com.poscodx.jblog.service;

import com.poscodx.jblog.repository.UserRepository;
import com.poscodx.jblog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void join(UserVo userVo){
        System.out.println(">>> userService : userVo > " + userVo);
        userRepository.insert(userVo);
        System.out.println(">>> userService : sql 후. > " + userVo);

    }

    public UserVo getUser(String id, String password){
        System.out.println(">>>>>"+id +password);
        return userRepository.findByIdAndPassword(id, password);
    }


}
