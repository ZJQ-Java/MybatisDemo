package com.qiu.mapper;

import com.qiu.pojo.Teacher;
import com.qiu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TeacherMapperTest {
    @Test
    public void selectTeacherAssociation() throws IOException {
        SqlSession session = MybatisUtil.getSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.selectTeacherAssociation();
        System.out.println(teachers);
    }

}
