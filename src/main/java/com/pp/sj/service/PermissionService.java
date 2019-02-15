package com.pp.sj.service;

import java.util.List;

import com.pp.sj.entry.Permission;

public interface PermissionService {

	List<Permission> getByRid(int rid);
}
