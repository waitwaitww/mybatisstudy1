package com.mapper;

import com.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User getUserbyid(int id);

    List<User> getUserByLimit(Map<String,Integer> map);

    List<User> getUserByRowBounds();

}
