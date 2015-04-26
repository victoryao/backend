package com.yaohoo.be.dao.mapper.read;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yaohoo.be.dao.entity.User;

public interface UserReadMapper {
	
	@Select("select id,name,password,phone from user where id = #{id}")
	public User getUserById(@Param("id") int id);

}
