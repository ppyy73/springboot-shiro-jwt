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
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

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
@Api(value = "admin", tags = "admin Controller")
public class AdminController {

	@PostMapping("/add")
	@RequiresPermissions("add")
	@ApiModelProperty("add demo")
	public String add() {
		return "add success";
	}

	@GetMapping("/find")
	@RequiresPermissions("select")
	@ApiOperation("select demo")
	public String find() {
		return "find success";
	}

	@PutMapping("/update")
	@RequiresPermissions("update")
	@ApiOperation("update demo")
	public String update() {
		return "update success";
	}

	@DeleteMapping("/delete")
	@RequiresPermissions("delete")
	@ApiOperation("delete demo")
	public String delete() {
		return "delete success";

	}

}
