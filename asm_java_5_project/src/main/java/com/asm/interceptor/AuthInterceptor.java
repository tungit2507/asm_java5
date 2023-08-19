package com.asm.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.asm.constant.sessionAttribute;
import com.asm.model.users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Component
public class AuthInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session =  request.getSession();
		users users =  (users) session.getAttribute(sessionAttribute.CURRENT_USER);
		if(users==null) {
			response.sendRedirect("/account/login");
			return false;
		}
		return true;
	}
}
