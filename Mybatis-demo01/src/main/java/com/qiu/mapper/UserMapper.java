package com.qiu.mapper;

import com.qiu.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User> selectUsers();

    public User selectUser(int id);

    public int addUser(User user);

    public int updateUser(User user);

    @Delete(value = " delete from mybatis.user where id=#{id} ")
    public int delUser(int id);

    public User selectByMap(Map<String ,Object> map);

    public List<User> selectUserLike(@Param("name") String _name);

    public List<User> selectUserIf(@Param("name") String _name,@Param("pwd") String pwd);

    public List<User> selectUserForeach(List<Integer> ids);
}
