package com.lecture.education.security;


import com.lecture.education.vo.UserVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@ToString
public class SecurityUser extends User implements OAuth2User {
    private UserVO userVO;
    private Map<String, Object> attributes;
    private int majorId;

    public SecurityUser(UserVO userVO, Collection<? extends GrantedAuthority> authorities,int majorId) {
        super(userVO.getId(), userVO.getPw(), authorities);
        this.userVO = userVO;
        this.majorId = majorId;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public String getName() {
        return this.userVO.getId();

    }


}
