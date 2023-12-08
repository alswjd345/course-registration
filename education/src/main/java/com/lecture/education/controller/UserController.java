package com.lecture.education.controller;

import com.lecture.education.mapper.MajorMapper;
import com.lecture.education.mapper.UserMapper;
import com.lecture.education.security.SecurityUser;
import com.lecture.education.service.UserService;
import com.lecture.education.vo.MajorVO;
import com.lecture.education.vo.TakeClassVO;
import com.lecture.education.vo.UserVO;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private UserMapper userMapper;

    //회원 가입
    @GetMapping("/signup")
    public String get_signup(Model model, @RequestParam(value="msg", required = false) String msg){
        List<MajorVO> majors=majorMapper.get_major();
        model.addAttribute("majors",majors);
        return "signup";
    }
    @PostMapping("/signup")
    public String post_signup(UserVO vo,Model model,@RequestParam("major_id") int majorId,HttpSession session){
        Object id_check=session.getAttribute("idVerified");
        try {
            if((boolean)id_check){
                vo.setMajor_id(majorId);
                userService.signup(vo);
                return "redirect:/";
            }
        }catch (Exception e){
            model.addAttribute("msg",e.getMessage());
        }
        return "redirect:signup";
    }
    //아이디 중복확인
    @ResponseBody
    @GetMapping("/signup/{id}")
    public boolean check_id(HttpSession session, @RequestParam String userId){
        int checked = userMapper.check_user_id(userId);
        // DB에 해당 아이디 존재 한다
        if (checked != 0) {
            log.info("기존 유저가 사용 중인 ID!");
            session.setAttribute("idVerified",false);
            return false;
        }
        // 존재하지 않는다.
        log.info("가입 가능한 ID!");
        session.setAttribute("idVerified",true);
        return true;
    }



    @GetMapping("/login")
    public void  get_login(){

    }
    @PostMapping("/login")
    public void post_login(){

    }
    //회원 정보 수정
    @GetMapping("/edit")
    public String get_edit( Model model
                            ,@AuthenticationPrincipal SecurityUser user
                            ,@RequestParam(value="msg", required = false) String msg){
        //로그인한 유저의 id를 가지고 전공 찾아서 뷰로 보여줌
        String id=user.getUsername();
        UserVO userVO=userMapper.getUserWithMajor(id);
        model.addAttribute("userVO",userVO);
        model.addAttribute("msg", msg);
        model.addAttribute("user", user);
        return "edit";
    }
    @PostMapping("/edit")
    public String post_edit(UserVO userVO,
                            @AuthenticationPrincipal SecurityUser user){
        //회원 정보 수정
        userMapper.edit_user(userVO);
        return "redirect:/";
    }
    //나의 수강 내역 조회
    @GetMapping("/mycourses")
    public String my_select_course(@AuthenticationPrincipal SecurityUser user,
                                   Model model,
                                   @RequestParam(value="msg", required = false) String msg){
        //로그인한 유저 이름 뷰로 보여줌
        model.addAttribute("username",user.getUsername());
        //로그인한 유저의 수강 신청 내역
        List<TakeClassVO> takeClassVOS=userMapper.get_take_class(user.getUsername());
        model.addAttribute("takeClasses",takeClassVOS);
        return "myCourseList";
    }

}
