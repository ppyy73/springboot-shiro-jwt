package com.pp.sj.service;

import com.pp.sj.entry.User;

public interface UserService {

	User getById(int id);
	
	User getByUsername(String username);
}
