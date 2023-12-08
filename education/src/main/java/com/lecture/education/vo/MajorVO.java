package com.lecture.education.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MajorVO {
    private int major_id;
    private String major_name;
    private List<CourseVO> courseVO;
}
