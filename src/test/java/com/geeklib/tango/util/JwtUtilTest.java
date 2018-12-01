package com.geeklib.tango.util;

import org.junit.Test;

import com.geeklib.tango.entity.User;

import io.jsonwebtoken.Claims;

public class JwtUtilTest {

	@Test
	public void test() {
		
		User user = new User();
		user.setId(Long.valueOf(123));
		user.setNickName("hunima");
		user.setUsername("dashabi");
		
		String token = JwtUtil.createToken(user, System.currentTimeMillis());
		
		System.out.println(token);
		
		Claims claims = JwtUtil.parseToken(token);
		
		String id = claims.get("userId").toString();
		String username = claims.get("username").toString();
		String nickname = claims.get("nickname").toString();
		
		System.out.println(id + "/t" + username +"/t" + nickname);
		
	}

}
