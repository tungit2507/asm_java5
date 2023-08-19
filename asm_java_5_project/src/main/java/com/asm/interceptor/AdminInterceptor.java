package com.asm.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.asm.constant.sessionAttribute;
import com.asm.model.users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AdminInterceptor implements HandlerInterceptor{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		users users=(users) session.getAttribute(sessionAttribute.CURRENT_USER);
		System.out.println("Checked");
		if(users.getIsadmin()==false) {
			response.sendRedirect("/index");
			return false;
		}
		return true;
	}
}
