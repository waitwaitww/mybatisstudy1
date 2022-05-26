import com.mapper.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class MyTest {

    static Logger logger = Logger.getLogger(MyTest.class);
    @Test
    public void test(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User userlist = mapper.getUserbyid(1);
        System.out.println(userlist.toString());
        sqlsession.close();
    }

    @Test
    public void log4jTest(){
        logger.info("info:进入log4jTest");
        logger.debug("debug:进入了log4jTest");
        logger.error("error:进入了log4jTest");
    }

    @Test
    public void test2(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user.toString());
        }
        sqlsession.close();

    }

    @Test
    public void test3(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);

        //通过Java代码实现分页
        List<User> list = sqlsession.selectList("com.mapper.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User u : list) {
            System.out.println(u.toString());
        }

        sqlsession.close();
    }
}
