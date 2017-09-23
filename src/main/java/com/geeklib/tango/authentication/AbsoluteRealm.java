package com.geeklib.tango.authentication;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.geeklib.tango.entity.User;
import com.geeklib.tango.mapper.UserMapper;

/**
 * 绝对领域！！！！
 * TODO 基于<a href="">shiro</a>的安全验证领域
 * @author Geek1st
 * @version 1.0
 */
@Component
public class AbsoluteRealm extends AuthorizingRealm{

	@Resource
	UserMapper userMapper;
	
	/**
	 * @see org.apache.shiro.realm.AuthorizingRealm
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username = ((User)principals.getPrimaryPrincipal()).getUsername();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> roleName = userMapper.getRoleNameByUserName(username);
		authorizationInfo.addRoles(roleName);
		
		return authorizationInfo;
	}

	/**
	 * @see org.apache.shiro.realm.AuthorizingRealm
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		String username = token.getPrincipal().toString();
		User user = userMapper.getUserByUserName(username);
		
		if(null == user){
			throw new UnknownAccountException();
		}
		
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
		return authenticationInfo;
	}
	
}
