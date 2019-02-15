package com.pp.sj.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author pp
 * @Date 2019年2月14日下午5:29:06
 * @Description
 *
 */
@RestController
@RequestMapping("/user")
@RequiresRoles("user")
public class UserController {

	@RequestMapping("/select")
	@RequiresPermissions("select")
	public String demo() {
		return "select success";
	}

	@RequestMapping("/add")
	@RequiresPermissions("add")
	public String demo2() {
		return "add success";
	}

	@RequestMapping("/delete")
	@RequiresPermissions("delete")
	public String demo3() {
		return "delete success";
	}

	@RequestMapping("/update")
	@RequiresPermissions("update")
	public String demo4() {
		return "update success";
	}
}
