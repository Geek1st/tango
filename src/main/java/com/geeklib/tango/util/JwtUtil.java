package com.geeklib.tango.util;

import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.filter.GenericFilterBean;

import com.geeklib.tango.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtHandler;
import io.jsonwebtoken.JwtHandlerAdapter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;

public class JwtUtil {

	private final static String key = "8aj0Sz3";
		
	public static String createToken(User user, int ttl) {
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("userId", user.getId());
		claims.put("username", user.getUsername());
		claims.put("nickname", user.getNickName());
		
		JwtBuilder jwtBuilder = Jwts.builder()
				.setIssuedAt(Calendar.getInstance().getTime())
				.setClaims(claims)
				.setId(UUID.randomUUID().toString())
				.setSubject(String.valueOf(user.getId()))
				.signWith(signatureAlgorithm, Base64.getEncoder().encode(key.getBytes()) );
		
		
		String token = jwtBuilder.compact();
		
		return token;
	}
	
	public static Claims parseToken(String token) {
		
		Claims claims = Jwts.parser().setSigningKey(Base64.getEncoder().encode(key.getBytes())).parseClaimsJws(token).getBody();
		JwsHeader jwsHeader  =Jwts.parser().setSigningKey(Base64.getEncoder().encode(key.getBytes())).parseClaimsJws(token).getHeader();
		System.out.println(jwsHeader.get("alg"));
		System.out.println(jwsHeader.get("typ"));
		System.out.println(jwsHeader.getContentType());
		System.out.println(jwsHeader.getAlgorithm());
		return claims;
		
	}
}
