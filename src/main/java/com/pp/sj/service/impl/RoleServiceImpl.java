package com.pp.sj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pp.sj.entry.Role;
import com.pp.sj.mapper.RoleMapper;
import com.pp.sj.service.RoleService;
/**
 * 
 * @author pp
 * @Date 2019年2月14日下午5:29:53
 * @Description
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> getByUid(int uid) {
		List<Role> list = roleMapper.selectList(new QueryWrapper<Role>().eq("u_id", uid));
		return list;
	}

}
