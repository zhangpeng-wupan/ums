package cn.tedu.springbootums.service;

import cn.tedu.springbootums.entity.User;
import cn.tedu.springbootums.exception.PasswordErroException;
import cn.tedu.springbootums.exception.UsernameErroException;
import cn.tedu.springbootums.exception.UsernameLikeException;

/**
 * 业务层接口
 * 		1.注册
 * 		2.登录
 * @author Administrator
 *
 */
public interface IUserService {
	void register(User user) throws UsernameLikeException;
	User login(String username,String password) throws PasswordErroException, UsernameErroException;
}
