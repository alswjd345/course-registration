package com.lecture.education.service;

import com.lecture.education.mapper.TakeClassMapper;
import com.lecture.education.vo.TakeClassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakeClassService {
    @Autowired
    TakeClassMapper takeClassMapper;

    public void save(String user_id, int class_id){takeClassMapper.save(user_id,class_id);}
    public TakeClassVO save_confirm(String user_id, int class_id){return takeClassMapper.save_confirm(user_id,class_id);}
    public void course_delete(int take_id){takeClassMapper.course_delete(take_id);}
}
