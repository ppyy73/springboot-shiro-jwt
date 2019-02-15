package com.pp.sj.service;

import java.util.List;

import com.pp.sj.entry.Role;

public interface RoleService {
	List<Role> getByUid(int uid);
}
