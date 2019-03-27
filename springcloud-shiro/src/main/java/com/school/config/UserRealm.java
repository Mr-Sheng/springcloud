package com.school.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.school.pojo.User;
import com.school.service.UserService;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权逻辑");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
//		info.addStringPermission("user:add");
		
		Subject subject = SecurityUtils.getSubject();
		
		User user = (User) subject.getPrincipal();
		
		User dbUser = userService.findUserById(user.getId());
		
		info.addStringPermission(dbUser.getPerms());
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		
		UsernamePasswordToken authToken = (UsernamePasswordToken) token;
		
		User user = userService.findUserByName(authToken.getUsername());
		
		if (user==null) {
			return null;
		}
		
		return new SimpleAuthenticationInfo(user ,user.getPassword(),"");
	}

}
