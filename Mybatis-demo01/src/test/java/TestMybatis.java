import com.qiu.mapper.UserMapper;
import com.qiu.pojo.User;
import com.qiu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TestMybatis {
    @Test
    public void testUsersMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUsers();

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testUserMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userList = mapper.selectUser(1);
        System.out.println(userList);
    }

    @Test
    public void testAddMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(4, "i", "pw", new Date(), new Date()));
        System.out.println(i);
        User user = mapper.selectUser(4);
        System.out.println(user);
    }

    @Test
    public void testDelMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.delUser(4);
        User user = mapper.selectUser(4);
        System.out.println(user == null);
    }

    @Test
    public void testUpdateMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUser(4);
        System.out.println(user);
        int i = mapper.updateUser(new User(4, "close", "update", new Date(), new Date()));
        /*
        1.不使用缓存flushCache="true"
        2.sqlSession.commit()
        3.new SqlSession
         */

        System.out.println(i);
        user = sqlSession.getMapper(UserMapper.class).selectUser(4);
        System.out.println(user);
    }
}
