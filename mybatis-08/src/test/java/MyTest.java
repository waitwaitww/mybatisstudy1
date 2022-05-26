import com.mapper.BlogMapper;
import com.pojo.Blog;
import com.utils.IDUtils;
import com.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

@SuppressWarnings("All")
public class MyTest {
    @Test
    public void test(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        BlogMapper mapper = sqlsession.getMapper(BlogMapper.class);
        String id = new IDUtils().getID();
        Blog blog = new Blog(id, "wbh", "yky", new Date(), 9999);
        mapper.addBlog(blog);
        blog.setTitle("yky");
        blog.setId(IDUtils.getID());
        mapper.addBlog(blog);
        blog.setId(IDUtils.getID());
        blog.setTitle("fyk");
        mapper.addBlog(blog);

        sqlsession.commit();

        sqlsession.close();
    }

    @Test
    public void test1(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        BlogMapper mapper = sqlsession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("428af226cfe244b5a0140156cb283509");
        ids.add("e43a4eca7463426d9c9263305ae50660");
        hashMap.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogBylist(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog.toString());
        }

//        sqlsession.commit();
        sqlsession.close();
    }
}
