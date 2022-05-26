import com.mapper.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);

        List<User> userlist = mapper.getUserlist();

        for (User user : userlist) {
            System.out.println(user.toString());
        }
        sqlsession.close();
    }
}
