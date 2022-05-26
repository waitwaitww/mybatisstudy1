import com.mapper.teacherMapper;
import com.pojo.teacher;
import com.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();

        teacherMapper mapper = sqlsession.getMapper(teacherMapper.class);
        teacher teachers = mapper.getTeacherByid2(1);
        System.out.println(teachers.toString());
        sqlsession.close();
    }
}
