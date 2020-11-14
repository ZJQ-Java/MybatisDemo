import com.qiu.mapper.UserMapper;
import com.qiu.pojo.User;
import com.qiu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class TestMybatis {
    static Logger logger = Logger.getLogger(TestMybatis.class);

    @Test
    public void testUsersMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUsers();
        logger.info("logger info ");
        logger.debug("logger debug ");
        logger.error("logger error ");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testUserByMapMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "z");
        User userList = mapper.selectByMap(map);
        System.out.println(userList);
    }

    @Test
    public void testUserLikeMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUserLike("g");
        System.out.println(userList);
    }


    @Test
    public void testUserIfMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUserIf("close", "update");
        System.out.println(userList);
    }

    @Test
    public void testUserForeachMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUserForeach(Arrays.asList(1, 4));
        System.out.println(userList);
    }

    @Test
    public void testUserLimitMybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("limit",1);
        map.put("offset",2);
        List<User> userList = mapper.selectLimit(map);
        System.out.println(userList);
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
