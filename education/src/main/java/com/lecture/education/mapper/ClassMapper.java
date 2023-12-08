package com.lecture.education.mapper;

import com.lecture.education.vo.ClassVO;
import com.lecture.education.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {

    CourseVO get_class(int course_id);
    void update_stu(int class_id);
    void update_stu_delete(int class_id);
}
