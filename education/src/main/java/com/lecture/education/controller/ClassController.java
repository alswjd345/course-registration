package com.lecture.education.controller;

import com.lecture.education.mapper.ClassMapper;
import com.lecture.education.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClassController {
    @Autowired
    ClassMapper classMapper;

    //선택한 강의의 수업을 보여줌
    @GetMapping("/classes/{course_id}")
    public String classList(@PathVariable("course_id")int course_id, Model model){
        CourseVO courseVO= classMapper.get_class(course_id);
        model.addAttribute("classes", courseVO);
        return "classList";
    }
}
