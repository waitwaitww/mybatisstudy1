package com.dao;

import com.pojo.User;

import java.util.List;
import java.util.Map;

public interface Userdao {
    List<User> getUserlist();
    User getUserbyid(int id);
    User getUsernyname(String name);
    List<User> getUserlistlike(String str);
    boolean addUser(User u);
    boolean addUser2(Map<String,Object> map);
    boolean updateUser(User u);
    boolean deleteUser(int id);
}
