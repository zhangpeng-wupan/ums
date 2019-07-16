package cn.tedu.springbootums;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.springbootums.entity.User;
import cn.tedu.springbootums.exception.PasswordErroException;
import cn.tedu.springbootums.exception.UsernameErroException;
import cn.tedu.springbootums.exception.UsernameLikeException;
import cn.tedu.springbootums.mapper.UserMapper;
import cn.tedu.springbootums.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootUmsApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	//测试数据库连接是否正常
	@Autowired
	private DataSource dataSource;
	@Test
	public void getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		System.err.println("conn:"+conn);
	}
	//测试持久层登录，注册方法
	@Autowired
	private UserMapper userMapper;
	@Test
	public void addnew() {
		User user = new User();
		user.setUsername("妲己");
		user.setPassword("123456");
		user.setAge(21);
		Integer rows = userMapper.addnew(user );
		System.err.println("rows:"+rows);
	}
	@Test
	public void findByUsername() {
		User user = userMapper.findByUsername("妲己");
		System.err.println(user);
	}
	
	//测试业务层的登录，注册方法
	@Autowired
	private IUserService userService;
	
	@Test
	public void register() throws UsernameLikeException {
		User user = new User();
		user.setUsername("妖姬");
		user.setPassword("123456");
		user.setAge(21);
		userService.register(user);
	}
	@Test
	public void login() throws PasswordErroException, UsernameErroException {
		User user = userService.login("妖姬", "123456");
		System.err.println(user);
	}
	
	
}
