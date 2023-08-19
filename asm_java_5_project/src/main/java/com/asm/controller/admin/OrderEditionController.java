package com.asm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderEditionController {
	@GetMapping("editionOrders")
	public String orderEdition() {
		return "admin/EditionOrders";
	}
}
