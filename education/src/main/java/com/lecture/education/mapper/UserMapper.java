package com.lecture.education.mapper;

import com.lecture.education.vo.ClassVO;
import com.lecture.education.vo.TakeClassVO;
import com.lecture.education.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.SimpleTimeZone;

@Mapper
public interface UserMapper {
    void signup(UserVO vo);
    UserVO get_user(String id);
    UserVO getUserWithMajor(String id);
    //회원 정보 수정
    void edit_user(UserVO userVO);
    //나의 수강 내역 조회
    List<TakeClassVO> get_take_class(String user_id);
    int check_user_id(String userId);
}
