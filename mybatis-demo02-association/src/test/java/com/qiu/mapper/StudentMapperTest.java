package com.qiu.mapper;

import com.qiu.pojo.Student;
import com.qiu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class StudentMapperTest {
    @Test
    public void getAllStudent() throws IOException {
        SqlSession session = MybatisUtil.getSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.getAllStudent();
        System.out.println(allStudent);
    }

    @Test
    public void selectStudentAssociation() throws IOException {
        SqlSession session = MybatisUtil.getSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.selectStudentAssociation();
        System.out.println(allStudent);
    }
}
