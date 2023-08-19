package com.asm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeAdminController {
	@GetMapping("admin")
	public String adminIndex() {
		return "admin/index";
	}
	
}
