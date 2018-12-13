package com.geeklib.tango.system.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.geeklib.tango.system.entity.User;

public interface UserMapper {

	@Delete("DELETE FROM sys_user WHERE id = #{id}")
	int removeUserById(Long id);

	@Insert("INSERT INTO sys_user ( gmt_create, gmt_modify, username, password, nickname, mobile_phone, email, locking )\r\n" + 
			"VALUES\r\n" + 
			"	( 1, NOW(), NULL, #{username}, #{password}, #{nickname}, #{mobilePhone}, #{email}, 0 );")
	int saveUser(User record);

	@Select("SELECT * FROM sys_user WHERE id = #{id}")
	User getUserById(Long id);

	@Select("SELECT * FROM sys_user")
	List<User> listUser();

	@Update("UPDATE sys_user \r\n" + 
			"SET gmt_modify = '2018-09-09 23:08:08',\r\n" + 
			"password = 'admin',\r\n" + 
			"nickname = 'admin',\r\n" + 
			"mobile_phone = '13067749487',\r\n" + 
			"email = 'geek1st@live.com',\r\n" + 
			"locking = 1 \r\n" + 
			"WHERE\r\n" + 
			"	id = 1;")
	int updateUserbyId(User record);

    User getUserByUserName(String username);
    
    @Select("SELECT role.name FROM user LEFT JOIN role ON role.id = user.role_id where user.username = #{username}")
    Set<String> getRoleNameByUserName(String username);
}