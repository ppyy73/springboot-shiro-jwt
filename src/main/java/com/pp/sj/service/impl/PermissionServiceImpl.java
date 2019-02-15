package com.pp.sj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pp.sj.entry.Permission;
import com.pp.sj.mapper.PermissionMapper;
import com.pp.sj.service.PermissionService;

/**
 * 
 * @author pp
 * @Date 2019年2月14日下午5:29:48
 * @Description
 *
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> getByRid(int rid) {
		List<Permission> list = permissionMapper.selectList(new QueryWrapper<Permission>().eq("r_id", rid));
		return list;
	}

}
