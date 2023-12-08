package com.lecture.education.controller;

import com.lecture.education.mapper.MajorMapper;
import com.lecture.education.vo.MajorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MajorController {

    @Autowired
    MajorMapper majorMapper;

    //전공 수업 강의 조회
    @GetMapping("/major-lectures")
    public String get_course(Model model,@RequestParam(required=false) Integer major_id){
        //모든 전공 선택 옵션
        List<MajorVO> major=majorMapper.get_major();
        model.addAttribute("majors",major);

        if(major_id!=null){
            MajorVO selectmajor=majorMapper.get_select_course(major_id);
            model.addAttribute("courses", selectmajor);
        }
        return "courseList";
    }

}
