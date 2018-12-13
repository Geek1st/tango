package com.geeklib.tango.system.realm;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.geeklib.tango.system.entity.User;
import com.geeklib.tango.system.service.UserService;

/**
 * 用户名密码领域认证
 * @author Geek1st
 */
@Component
public class UsernamePasswordRealm extends AuthorizingRealm{

	@Resource
	UserService userService;
	
	/**
	 * @see org.apache.shiro.realm.AuthorizingRealm
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = ((User)principals.getPrimaryPrincipal()).getUsername();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> roleName = userService.getRoleNameByUserName(username);
		authorizationInfo.addRoles(roleName);
		
		return authorizationInfo;
	}

	/**
	 * @see org.apache.shiro.realm.AuthorizingRealm
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken usernamepasswordToken = (UsernamePasswordToken)token;
		String username = usernamepasswordToken.getUsername();
		String password = String.valueOf(usernamepasswordToken.getPassword());
		User user = userService.getUserByUsername(username);
		
		if(null == user){
			throw new UnknownAccountException("用户不存在");
		}
		
		if(!StringUtils.equals(password, user.getPassword())) {
			throw new AuthenticationException("密码错误");
		}
		
		if(user.getLocking()) {
			throw new LockedAccountException("当前账户已锁定");
		}
		
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
		return authenticationInfo;
	}
	
}
