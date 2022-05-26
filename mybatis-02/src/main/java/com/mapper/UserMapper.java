package com.mapper;

import com.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserlist();
    User getUserbyid(int id);
    List<User> getUserlistlike(String str);
    boolean addUser(User u);
    boolean updateUser(User u);
    boolean deleteUser(int id);
}
