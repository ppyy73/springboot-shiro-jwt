package com.pp.sj.config;

import org.apache.shiro.authc.HostAuthenticationToken;

/**
 * 
 * @author pp
 * @Date 2019年2月14日下午4:27:18
 * @Description 参照UsernamePasswordToken,用于扩展业务，由于rest api不需要rememberMe，已丢弃
 * 				HostAuthenticationToken，用来获取用户的host
 *
 */
public class JwtToken implements HostAuthenticationToken {

	private static final long serialVersionUID = 1L;
	private String username;
	private char[] password;
	private String host;

	private String token;

	public JwtToken(String token) {
		this.token = token;
	}

	public JwtToken(String username, char[] password) {
		this(username, password, (String) null);
	}

	public JwtToken(String username, String password) {
		this(username, (char[]) (null != password ? password.toCharArray() : null), (String) null);
	}

	public JwtToken(String username, char[] password, String host) {
		this.username = username;
		this.password = password;
		this.host = host;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public Object getPrincipal() {
		return this.getToken();
	}

	@Override
	public Object getCredentials() {
		return this.getToken();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
