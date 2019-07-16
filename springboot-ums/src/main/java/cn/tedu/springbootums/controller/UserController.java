package cn.tedu.springbootums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.springbootums.entity.User;
import cn.tedu.springbootums.exception.PasswordErroException;
import cn.tedu.springbootums.exception.UsernameErroException;
import cn.tedu.springbootums.exception.UsernameLikeException;
import cn.tedu.springbootums.service.IUserService;
import cn.tedu.springbootums.util.JsonResult;

@RequestMapping("user")
@RestController
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("handle_register")
	public JsonResult<Void> handleRegister(User user){
		JsonResult<Void> jr = new JsonResult<Void>();
		try {
			userService.register(user);
			jr.setState(1);
			jr.setMessage("注册成功");
		} catch (UsernameLikeException e) {
			jr.setState(2);
			jr.setMessage(e.getMessage());
		}
		return jr;
	}
	
	@RequestMapping("handle_login")
	public JsonResult<Void> handleLogin(String username,String password){
		JsonResult<Void> jr = new JsonResult<Void>();
		try {
			User user = userService.login(username, password);
			jr.setState(1);
		} catch (PasswordErroException e) {
			jr.setState(2);
			jr.setMessage(e.getMessage());
		}catch(UsernameErroException e) {
			jr.setState(3);
			jr.setMessage(e.getMessage());
		}
		return jr;
	}
	
	@RequestMapping("/")
	public JsonResult<Void> get(){
		return new JsonResult<>(2000);
	}
	
}
