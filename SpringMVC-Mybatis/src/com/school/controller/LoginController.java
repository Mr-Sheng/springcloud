package com.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpSession session ,String username,String password) throws Exception {
		
		session.setAttribute("username",username);
		
		return "redirect:/queryItems.action";
		
	}
	
	@RequestMapping("/logout")
	public String loginout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		return "redirect:/queryItems.action";
		
	}
	
	
}
