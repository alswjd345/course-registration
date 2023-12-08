package com.lecture.education.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@NoArgsConstructor
public class ClassVO {
    private int class_id;
    private int class_number;
    private int cur_student_num;
    private int max_student_num;
    private String professor_name;
    private int course_id;
    protected List<CourseVO> courseVO;
}
