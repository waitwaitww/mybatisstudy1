package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserByid(@Param("id") int id);

    @Select("select * from user")
    List<User> getUsers();

    boolean updateUser(Map map);

    boolean addUser(User user);
}
