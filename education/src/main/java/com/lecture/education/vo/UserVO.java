package com.lecture.education.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserVO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private int tel;
    private String role;
    private LocalDateTime create_date;
    private int major_id;
    private MajorVO majorVO;

}
