package com.pp.sj;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pp.sj.entry.Permission;
import com.pp.sj.entry.Role;
import com.pp.sj.entry.User;
import com.pp.sj.mapper.UserMapper;
import com.pp.sj.service.PermissionService;
import com.pp.sj.service.RoleService;
import com.pp.sj.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootShiroJwtApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMaper;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	@Test
	public void contextLoads() {
		User user = userService.getById(1);
		System.out.println(user.getUsername() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<Role> roles = roleService.getByUid(user.getId());
		for (Role role : roles) {
			System.out.println(role.getrName() + "++++++++++++++++++++++++");
			List<Permission> ps = permissionService.getByRid(role.getId());
			for (Permission p : ps) {
				System.out.println(p.getpName() + "--------------------------");
			}
		}

	}
	
	@Test
	public void demo() {
		User user = userMaper.selectById(1);
		System.out.println(user.getUsername());
	}

}
