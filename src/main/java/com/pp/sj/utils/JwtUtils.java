package com.pp.sj.utils;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * 
 * @author pp
 * @Date 2019年2月14日下午5:30:11
 * @Description
 *
 */
public class JwtUtils {

  private static final long EXPIRE_TIME = 60 * 60 * 1000;

  private static final String CLAIM_NAME = "username";

  public static String createToken(String username, String password) {
    Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
    //加密处理密码
    Algorithm algorithm = Algorithm.HMAC256(password);
    return JWT.create()
        .withClaim(CLAIM_NAME, username)
        .withExpiresAt(date)
        .sign(algorithm);
  }

  public static boolean verify(String username, String dbPwd, String token) {
    Algorithm algorithm = Algorithm.HMAC256(dbPwd);
    JWTVerifier jwtVerifier = JWT.require(algorithm)
        .withClaim(CLAIM_NAME, username).build();
    try {
      jwtVerifier.verify(token);
    } catch (JWTVerificationException e) {
      return false;
    }
    return true;
  }

  public static String getUserName(String token) {
    try {
      DecodedJWT jwt = JWT.decode(token);
      return jwt.getClaim(CLAIM_NAME).asString();
    } catch (JWTDecodeException e) {
      return null;
    }
  }

}
