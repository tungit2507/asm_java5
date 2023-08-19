package com.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.constant.sessionAttribute;
import com.asm.model.cart_item;
import com.asm.model.users;
import com.asm.service.CartItemService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("checkout")
public class CheckOutController {
	@Autowired
	CartItemService CartItemService;
	@Autowired
	HttpSession HttpSession;
	@GetMapping("")
	public String checkout(Model model, @RequestParam("shoppingid") String id) {
		List<cart_item> list = CartItemService.selectByCurrentUser();
		users user = (users) HttpSession.getAttribute(sessionAttribute.CURRENT_USER);
		Double sum = 0.0;
		for (cart_item cart_item : list) {
			sum += cart_item.getQuantity()*cart_item.getProduct().getPrice();
		}
		model.addAttribute("sum",sum);
		model.addAttribute("user",user);
		model.addAttribute("list",list);
		return "user/checkout";
	}
}
