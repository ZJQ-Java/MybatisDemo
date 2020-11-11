package com.qiu.mapper;

import com.qiu.pojo.User;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface UserMapper {
    public List<User> selectUsers();

    public User selectUser(int id);

    public int addUser(User user);

    public int updateUser(User user);

    @Delete(value = " delete from mybatis.user where id=#{id} ")
    public int delUser(int id);
}
