import com.mapper.studentMapper;
import com.mapper.teacherMapper;
import com.pojo.student;
import com.pojo.teacher;
import com.utils.MybatisUtil;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class MyTest {
    @Test
    public void test(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        teacherMapper mapper = sqlsession.getMapper(teacherMapper.class);

        teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher.toString());

        sqlsession.close();
    }

    @Test
    public void test1(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        studentMapper mapper = sqlsession.getMapper(studentMapper.class);

        List<student> student = mapper.getStudent2  ();
        for (com.pojo.student student1 : student) {
            System.out.println(student1.toString());
        }

        sqlsession.close();
    }
}
