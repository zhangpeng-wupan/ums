package cn.tedu.springbootums.mapper;

import cn.tedu.springbootums.entity.User;

public interface UserMapper {
	Integer addnew(User user);
	User findByUsername(String username);
}
