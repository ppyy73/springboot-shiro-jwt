package com.pp.sj.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pp.sj.config.Constant;
import com.pp.sj.config.Result;

/**
 * 
 * @author pp
 * @Date 2019年2月14日下午2:47:13
 * @Description 处理异常，并返回结果
 */
@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
	public Result unauthenticatedException() {
		Result result = new Result();
		result.setCode(Constant.UNAUTHENTICATED);
		result.setMsg("对不起,您还未登录!");
		return result;
	}

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseBody
	public Result unauthorizedException() {
		Result result = new Result();
		result.setCode(Constant.UNAUTHORIZED);
		result.setMsg("对不起,您没权限操作!");
		return result;
	}

	@ExceptionHandler(UnknownAccountException.class)
	@ResponseBody
	public Result unknownAccountException() {
		Result result = new Result();
		result.setCode(Constant.BUSINESS_ERROR);
		result.setMsg("登陆失败,用户名或密码错误!");
		return result;
	}
}
