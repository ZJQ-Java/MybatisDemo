package com.qiu.mapper;

import com.qiu.pojo.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> getAllStudent();
    public List<Student> selectStudentAssociation();
}
