package com.school.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/index")
    public String testThymeleaf(Model model) {
		System.out.println("------首页-----");
        // 把数据存入model
        model.addAttribute("title", "首页->SpringBoot与Shiro整合");
        // 返回test.html
        return "index";
    }
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("------登录页-----");
		return "/user/login";
	}
	
	@RequestMapping("/auth") //特别注意：这里的参数列表中的符号必须与前端提交的form表单的名字一致，否则就惨了
	public String auth(String name,String password,Model model) {
		
		System.out.println("------认证流程-----");
		
		//1、获取subject
		Subject subject = SecurityUtils.getSubject();
		//2、封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		//3、执行登录方法
		try {
			subject.login(token);//登陆成功
			return "index";
		} catch (UnknownAccountException e) {
			//登录失败：用户名不存在
			model.addAttribute("msg","用户名不存在");
			return "user/login";
		} catch (IncorrectCredentialsException e) {
			//登录失败，密码错误
			model.addAttribute("msg","密码错误");
			return "user/login";
		}
	}
	
	@RequestMapping("/unAuth")
	public String unAuth() {
		return "unAuth";
	}

	@RequestMapping("/add")
	public String add() {
		return "user/add";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "user/update";
	}
	
}
