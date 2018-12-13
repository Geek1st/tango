package com.geeklib.tango.util;

import org.junit.Test;

import com.geeklib.tango.system.entity.User;

import io.jsonwebtoken.Claims;

public class JwtUtilTest {

	@Test
	public void test() {
		
		User user = new User();
		user.setId(Long.valueOf(123));
		user.setNickname("hunima");
		user.setUsername("dashabi");
		
		String token = JwtUtil.createToken(user, 10000000);
		
		System.out.println(token);
		
		Claims claims = JwtUtil.parseToken(token);
		
		String id = claims.get("userId").toString();
		String username = claims.get("username").toString();
		String nickname = claims.get("nickname").toString();
		
		System.out.println(id + "/t" + username +"/t" + nickname);
		
	}

}
