package com.pp.sj.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author pp
 * @Date 2019年2月14日下午3:07:12
 * @Description
 *
 */
@RestController
@RequestMapping("/admin")
@RequiresRoles("admin")
public class AdminController {

	@RequestMapping("/add")
	@RequiresPermissions("add")
	public String add() {
		return "add success";
	}

	@PostMapping("/find")
	@RequiresPermissions("select")
	public String find() {
		return "find success";
	}

	@PostMapping("/update")
	@RequiresPermissions("update")
	public String update() {
		return "update success";
	}

	@PostMapping("/delete")
	@RequiresPermissions("delete")
	public String delete() {
		return "delete success";

	}

}
