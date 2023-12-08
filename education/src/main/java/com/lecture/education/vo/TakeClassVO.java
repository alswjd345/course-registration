package com.lecture.education.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class TakeClassVO {
    private int take_id;
    private int class_id;
    private String user_id;
    private List<CourseVO> courseVO;
    private List<ClassVO> classVO;
}
