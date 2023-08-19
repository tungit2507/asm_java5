package com.asm.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterCeptorConfig  implements WebMvcConfigurer{
	
	@Autowired 
	AuthInterceptor authInterceptor;
	@Autowired
	AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(authInterceptor)
		.addPathPatterns("/cart/**")
		.addPathPatterns("/admin");
		
		
		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/admin");
	}
}
