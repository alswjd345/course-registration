package com.lecture.education.controller;

import com.lecture.education.mapper.UserMapper;
import com.lecture.education.vo.UserVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class MainController {


    @GetMapping("/")
    public String main(Model model){
        Object user= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != "anonymousUser") {
            model.addAttribute("user", (User) user);
            log.info(user);
        }
        return "home";
    }
}
