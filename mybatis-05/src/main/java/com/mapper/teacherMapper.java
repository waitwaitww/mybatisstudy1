package com.mapper;

import com.pojo.teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface teacherMapper {

    @Select("select * from teacher where id = #{tid}")
    teacher getTeacher(@Param("tid") int id);
}
