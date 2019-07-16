package cn.tedu.springbootums.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.springbootums.entity.User;
import cn.tedu.springbootums.exception.PasswordErroException;
import cn.tedu.springbootums.exception.UsernameErroException;
import cn.tedu.springbootums.exception.UsernameLikeException;
import cn.tedu.springbootums.mapper.UserMapper;

/**
 * 业务层实现类，处理注册，登录
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
	
	//注册
	@Override
	public void register(User user) throws UsernameLikeException {
		String username = user.getUsername();
		User result = userMapper.findByUsername(username);
		if(result==null) {
			userMapper.addnew(user);
			System.err.println("注册成功");
		}else {
			throw new UsernameLikeException("你所注册的用户名"+username+"已被占用");
		}
	}
	//登录
	@Override
	public User login(String username,String password ) throws PasswordErroException, UsernameErroException {
		User user = userMapper.findByUsername(username);
		if(user!=null) {
			if(password.equals(user.getPassword())) {
				System.err.println("登录成功！");
			}else {
				throw new PasswordErroException("密码不正确");
			}
		}else {
			throw new UsernameErroException("用户名不正确");
		}
		return user;
	}
	
	
}
