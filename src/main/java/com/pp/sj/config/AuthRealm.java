package com.pp.sj.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.pp.sj.entry.Permission;
import com.pp.sj.entry.Role;
import com.pp.sj.entry.User;
import com.pp.sj.service.PermissionService;
import com.pp.sj.service.RoleService;
import com.pp.sj.service.UserService;
import com.pp.sj.utils.JwtUtils;

/**
 * 
 * @author pp
 * @Date 2019年2月14日下午3:12:39
 * @Description 自定义realm，主要完成shiro的登录和授权工作
 *
 */
public class AuthRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	/**
	 * 设置realm支持的authenticationToken类型
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		return null != token && token instanceof JwtToken;
	}

	/**
	 * 登陆认证
	 *
	 * @param authenticationToken jwtFilter传入的token
	 * @return 登陆信息
	 * @throws AuthenticationException 未登陆抛出异常
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// getCredentials getPrincipal getToken 都是返回jwt生成的token串
		String token = (String) authenticationToken.getCredentials();

		String username = JwtUtils.getUserName(token);
		if (username == null) {
			throw new AccountException("token invalid");
		}
		User user = userService.getByUsername(username);
		if (!JwtUtils.verify(username, user.getPassword(), token)) {
			throw new UnknownAccountException("Username or password error");
		}

		return new SimpleAuthenticationInfo(token, token, getName());
	}

	/**
	 * 授权认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String token = principalCollection.toString();
		// 根据token获取权限授权
		String userName = JwtUtils.getUserName(token);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = userService.getByUsername(userName);
		List<Role> roles = roleService.getByUid(user.getId());

		Set<String> rSet = new HashSet<>();
		Set<String> pSet = new HashSet<>();
		for (Role role : roles) {

			rSet.add(role.getrName());
			List<Permission> ps = permissionService.getByRid(role.getId());
			for (Permission p : ps) {

				pSet.add(p.getpName());
			}
		}

		authorizationInfo.setRoles(rSet);
		authorizationInfo.setStringPermissions(pSet);
		return authorizationInfo;
	}
}
