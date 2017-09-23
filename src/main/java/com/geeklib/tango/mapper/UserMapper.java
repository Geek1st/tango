package com.geeklib.tango.mapper;

import com.geeklib.tango.entity.User;
import com.geeklib.tango.entity.UserExample;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    
    @Select("SELECT * FROM user LEFT JOIN role ON role.id = user.role_id where user.username = #{username}")
    User getUserByUserName(String username);
    
    @Select("SELECT role.name FROM user LEFT JOIN role ON role.id = user.role_id where user.username = #{username}")
    Set<String> getRoleNameByUserName(String username);
}