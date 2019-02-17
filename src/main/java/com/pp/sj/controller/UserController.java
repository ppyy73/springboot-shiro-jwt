package com.pp.sj.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@Api(value = "user", tags = "user Controller")
public class UserController {

	@GetMapping("/select")
	@RequiresPermissions("select")
	@ApiOperation("select demo")
	public String demo() {
		return "select success";
	}

	@PostMapping("/add")
	@RequiresPermissions("add")
	@ApiOperation("add demo")
	public String demo2() {
		return "add success";
	}

	@DeleteMapping("/delete")
	@RequiresPermissions("delete")
	@ApiOperation("delete demo")
	public String demo3() {
		return "delete success";
	}

	@PutMapping("/update")
	@RequiresPermissions("update")
	@ApiOperation("update demo")
	public String demo4() {
		return "update success";
	}
}
