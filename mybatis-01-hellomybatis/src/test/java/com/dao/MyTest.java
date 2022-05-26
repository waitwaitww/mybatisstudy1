package com.dao;

import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.jws.Oneway;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test(){
        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql
        Userdao mapper = sqlSession.getMapper(Userdao.class);
        List<User> userlist = mapper.getUserlist();
        User u1 = mapper.getUserbyid(1);
        System.out.println(u1.toString());

        //方式二：
        //sqlSession.selectList("com.dao.Userdao.getUserlist");


        for (User u : userlist) {
            System.out.println(u.toString());
        }
        //关闭sqlsesson
        sqlSession.close();
    }
    //增删改需要提交事务
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Userdao mapper = sqlSession.getMapper(Userdao.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("uid",6);
        map.put("uname","wbh");
        map.put("upwd","123456");
        mapper.addUser2(map);

//        User u1 = new User(5,"wbh","123456");
//        System.out.println(mapper.addUser(u1));

        User u2 = new User(5,"景涛","123321");
        System.out.println(mapper.updateUser(u2));

        //mapper.deleteUser(5);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Userdao mapper = sqlSession.getMapper(Userdao.class);
        String str = "9";
        List<User> userList = mapper.getUserlistlike(str);
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
}
