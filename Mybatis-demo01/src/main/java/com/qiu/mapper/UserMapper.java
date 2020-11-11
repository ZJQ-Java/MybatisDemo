package com.qiu.mapper;

import com.qiu.pojo.User;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface UserMapper {
    public List<User> selectUsers();

    public User selectUser(int id);

    public void addUser(User user);

    public void updateUser(User user);

    @Delete(value = " delete from mybatis.user where id=#{id} ")
    public void delUser(int id);
}
