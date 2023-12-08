package com.lecture.education.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseVO {
    private int course_id;
    private String course_name;
    private int major_id;
    private List<MajorVO> majorVO;
    private List<ClassVO> classVO;
}
