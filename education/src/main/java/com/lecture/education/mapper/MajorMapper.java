package com.lecture.education.mapper;

import com.lecture.education.vo.CourseVO;
import com.lecture.education.vo.MajorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorMapper {
    List<MajorVO> get_major();
    MajorVO get_select_course(Integer major_id);
}
