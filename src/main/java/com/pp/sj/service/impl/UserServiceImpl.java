package com.pp.sj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pp.sj.entry.User;
import com.pp.sj.mapper.UserMapper;
import com.pp.sj.service.UserService;
/**
 * 
 * @author pp
 * @Date 2019年2月14日下午5:29:59
 * @Description
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getById(int id) {
		return userMapper.selectById(id);
	}

	@Override
	public User getByUsername(String username) {
		User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
		return user;
	}

}
