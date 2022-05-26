import com.mapper.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtil;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("All")
public class MyTest {

    @Test
    public void test(){
        //一级缓存自动开启，只在一次sqlsession中有效，也就是拿到链接到关闭连接这个时间段
        SqlSession sqlsession = MybatisUtil.getSqlsession();
//        SqlSession sqlsession1 = MybatisUtil.getSqlsession();

        //只要开启了二级缓存，在同一个Mapper中都有效
        //所以的数据都优先存在于一级缓存，只有当会话提交或者关闭的时候才会到二级缓存

//        UserMapper mapper1 = sqlsession1.getMapper(UserMapper.class);
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);

        User user = mapper.getUserByid(1);
        System.out.println(user.toString());
        sqlsession.close();
        System.out.println("====================================================");

//        try {
//            Thread.sleep(65000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        User userByid = mapper1.getUserByid(1);
//        System.out.println(userByid.toString());
//        sqlsession1.close();
//        System.out.println("====================================================");

//        HashMap hashMap = new HashMap();
//        hashMap.put("id",1);
//        hashMap.put("name","杨锋");
//        hashMap.put("pwd","112233");
//        mapper.updateUser(hashMap);
//        System.out.println("====================================================");

//        User user1 = mapper.getUserByid(2);
//        System.out.println(user1.toString());
//        System.out.println("====================================================");
//
//        一级缓存失效时间：
        //增删改操作可能会改变原来的数据，所以必定清除缓存
        //查询不同的mapper.xml
        //手动清理存
//        User user3 = new User(10, "yyy", "3213123");
//        mapper.addUser(user3);
//        System.out.println("====================================================");

//        sqlsession.clearCache();//清理sqlsession缓存
//
//        User user2 = mapper.getUserByid(1);
//        System.out.println(user2.toString());
//        System.out.println(user.toString());
//        System.out.println("====================================================");
//
//        List<User> users = mapper.getUsers();
//        for (User u : users) {
//            System.out.println(u.toString());
//        }

//        System.out.println(user == user2);

    }
}
