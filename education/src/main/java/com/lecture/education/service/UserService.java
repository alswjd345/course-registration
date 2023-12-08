package com.lecture.education.service;

import com.lecture.education.mapper.UserMapper;
import com.lecture.education.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    public void signup(UserVO vo){
        // 유저의 비밀번호 인코딩
        vo.setPw(passwordEncoder.encode(vo.getPw()));
        // 유저 등록
        userMapper.signup(vo);
    }

}
