package com.pp.sj.controller;

import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pp.sj.config.Constant;
import com.pp.sj.config.Result;
import com.pp.sj.entry.User;
import com.pp.sj.service.UserService;
import com.pp.sj.utils.JwtUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author pp
 * @Date 2019年2月14日下午3:31:22
 * @Description
 *
 */
@RestController
@Api(value = "login", tags = "login Controller")
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	@ApiOperation("login demo")
	public Result login(@RequestBody User user) {

		String username = user.getUsername();
		String password = user.getPassword();
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			Result result = new Result();
			result.setCode(Constant.BUSINESS_ERROR);
			result.setMsg("账号和密码不能为空!");
			return result;
		}
		User user2 = userService.getByUsername(username);
		if (null == user2 || !password.equals(user2.getPassword())) {
			throw new UnknownAccountException("用户名和密码错误");
		}
		String msg = "登录成功,请妥善保管您的token,有效期1小时!";
		return new Result(msg, JwtUtils.createToken(username, password));
	}

}
