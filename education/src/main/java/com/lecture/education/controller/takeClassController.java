package com.lecture.education.controller;

import com.lecture.education.mapper.*;
import com.lecture.education.security.SecurityUser;
import com.lecture.education.service.TakeClassService;
import com.lecture.education.vo.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@Log4j2
public class takeClassController {
    @Autowired
    MajorMapper majorMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TakeClassService takeClassService;
    @Autowired
    TakeClassMapper takeClassMapper;
    @Autowired
    ClassMapper classMapper;

    //수강 신청
    @GetMapping ("/register")
    public String courseRegistration(Model model,
                                     @RequestParam(value  = "msg", required = false) String msg,
                                     @RequestParam(value = "course_id",required = false) Integer course_id,
                                     @AuthenticationPrincipal SecurityUser user){
        UserVO userVO=userMapper.getUserWithMajor(user.getUsername());
        MajorVO majorVO=majorMapper.get_select_course(userVO.getMajor_id());
       if(course_id != null){
           CourseVO courseVO = classMapper.get_class(course_id);
           model.addAttribute("classes", courseVO);
       }
       model.addAttribute("courses",majorVO);
       model.addAttribute("userVO",userVO);
       model.addAttribute("msg", msg);
       return "courseRegistration";
    }
    //수강 신청
    @GetMapping("/register/{id}")
    public String courseRegister(@PathVariable("id") Integer class_id, @AuthenticationPrincipal SecurityUser user) {
        try {
            String user_id=user.getUsername();
            if(class_id != null && user !=null){
               TakeClassVO takeClassVO= takeClassService.save_confirm(user_id,class_id);
               if(takeClassVO!=null){
                   return "redirect:/register?msg=Error";
               }
                takeClassService.save(user_id,class_id);
            }
        } catch (IllegalArgumentException e) {
            return "redirect:/register?msg=" + e.getMessage();
        }
        classMapper.update_stu(class_id);
        return "redirect:/register?msg=Success!";
    }
    //수강 신청 취소
    @GetMapping("/cancel/{id}/{class_id}")
    public String courseCancel(@PathVariable("id") int take_id,@PathVariable("class_id") int class_id){
        classMapper.update_stu_delete(class_id);
        takeClassService.course_delete(take_id);
        return "redirect:/mycourses?msg=Success!";
    }


}
