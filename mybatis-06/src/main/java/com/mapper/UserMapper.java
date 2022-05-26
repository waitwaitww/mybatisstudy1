package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from mybatis.user")
    List<User> getUserList();

    //方法存在多个参数,所有参数前面必须都加@Param
    //sql语句中的参数'id'以@Param的为主
    @Select("select * from mybatis.user where id = #{id}")
    User getUserbyid(@Param("id") int id);

    @Insert("insert into mybatis.user(id,name,pwd) value (#{id},#{name},#{password})")
    boolean addUser(User u);

    @Update("update mybatis.user set name=#{name},pwd=#{password} where id = #{id}")
    boolean updateUser(User u);

    @Delete("delete from user where id = #{uid}")
    boolean deleteUserByid(@Param("uid") int id);
}
