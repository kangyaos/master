package com.jiaoda.edu.util;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtil {

	public static String secret = "Sxhalo.com";

	public static Long expiration = 28800l;//8小时

	public static String createToken(Integer userCode, Integer roleId) {
		String token = Jwts.builder().claim("userCode", userCode).claim("roleId", roleId)
				.setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compressWith(CompressionCodecs.GZIP).compact();
		return token;
	}

	public static Integer getUserCode(String token) {
		String userCode = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("userCode").toString();
		return Integer.parseInt(userCode);
	}

	public static Integer getRoleId(String token) {
		String roleId = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("roleId").toString();
		return Integer.parseInt(roleId);
	}

	public static Boolean verifyToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims != null;
	}

}
