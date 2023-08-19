package com.asm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssessEditionController {
	@GetMapping("editionAssess")
	public String index() {
		return "admin/EditionAssess";
	}
}
