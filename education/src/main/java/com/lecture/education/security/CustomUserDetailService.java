package com.lecture.education.security;

import com.lecture.education.mapper.UserMapper;
import com.lecture.education.vo.UserVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UserVO userVO = userMapper.get_user(username);
        userVO.setMajor_id(userVO.getMajor_id());
        log.info(username);
        if (userVO == null) {
            throw new UsernameNotFoundException("ERROR: USER NOT FOUND!");
        }
        // 유저가 있었다면 그 유저의 내용으로 User 객체를 생성한 뒤 반환
        GrantedAuthority authorities = new SimpleGrantedAuthority("ROLE_" + userVO.getRole());
        int majorId = userVO.getMajor_id();
        return new SecurityUser(userVO, List.of(authorities), majorId);
//        return User
//                .withUsername(userVO.getId())
//                .password(userVO.getPw())
//                .authorities("ROLE_USER")
//                .build();
    }
}
