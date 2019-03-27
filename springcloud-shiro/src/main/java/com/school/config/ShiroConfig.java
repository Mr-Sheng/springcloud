package com.school.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	/**
	 * 创建ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//shiroFilterFactoryBean需要关联securityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		// 添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *  常用的过滤器：
         *      anon: 无需认证（登录）可以访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用rememberMe功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */
		 Map<String, String> filterMap = new LinkedHashMap<>();
		 
//		 filterMap.put("/add", "authc");
//		 filterMap.put("/update", "authc");
		 
		 //下面两个顺序不能颠倒，先把首页testThymeleaf放到无需认证列表里面，然后在列出需要进行过滤的页面
		 filterMap.put("/index", "anon");
		 filterMap.put("/auth", "anon");
		 
		 filterMap.put("/add", "perms[user:add]");
		 filterMap.put("/update", "perms[user:update]");
		 
		 filterMap.put("/*", "authc");
		 
		 shiroFilterFactoryBean.setLoginUrl("/login");
		 
		 shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
		 
		 shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		 
		 return shiroFilterFactoryBean;
	}
	
	
	/**
	 * 创建DefaultWebSecurityManager
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//securityManager需要关联Realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	
	
	/**
	 * 创建Realm
	 */
	@Bean(name = "userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
	
	
}
