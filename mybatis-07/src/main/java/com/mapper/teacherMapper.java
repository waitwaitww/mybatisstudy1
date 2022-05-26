package com.mapper;

import com.pojo.teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface teacherMapper {

    @Select("select * from teacher")
    List<teacher> getTeacher();

    teacher getTeacherByid(@Param("tid") int id);

    teacher getTeacherByid2(@Param("tid") int id);

}
