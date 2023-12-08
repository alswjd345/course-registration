package com.lecture.education.mapper;

import com.lecture.education.vo.TakeClassVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TakeClassMapper {
    void save(String user_id, int class_id);
    TakeClassVO save_confirm(String user_id, int class_id);
    void course_delete(int take_id);
}
