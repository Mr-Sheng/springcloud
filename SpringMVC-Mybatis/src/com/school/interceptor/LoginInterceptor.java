package com.school.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
//		String url = request.getRequestURI();
//		
//		if (url.indexOf("login.action")>=0) {
//			return true;
//		}
//		
//		HttpSession session = request.getSession();
//		String username = (String) session.getAttribute("username");
//		if (username!=null) {
//			return true;
//		}
//		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
//		return false;
		return true;
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
