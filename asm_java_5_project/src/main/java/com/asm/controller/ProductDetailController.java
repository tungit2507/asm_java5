package com.asm.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.constant.sessionAttribute;
import com.asm.model.product;
import com.asm.model.product_access;
import com.asm.model.product_category;
import com.asm.model.users;
import com.asm.service.ProductsService;

import jakarta.mail.internet.ParseException;

@Controller
@RequestMapping("productdetail")
public class ProductDetailController {
	@Autowired
	ProductsService productService;
	@Autowired
	jakarta.servlet.http.HttpSession HttpSession;
	@Autowired
	com.asm.service.ProductAssessService ProductAssessService;
	@GetMapping("")
	public String productForm(Model model, @RequestParam("productid") String id) {
		Optional<product> Oproduct = productService.FindById(id);
		users user = (users) HttpSession.getAttribute(sessionAttribute.CURRENT_USER);
		if(user != null) {
			model.addAttribute("hidden","");
		}else {
			model.addAttribute("hidden","hidden");
		}
		Integer count  = ProductAssessService.countProductAccess(id);
		model.addAttribute("count",count);
		product product = Oproduct.orElse(new product());
		List<product_access> product_access1 = ProductAssessService.findByProduct(product);
		Integer avg = ProductAssessService.avgStart_rate(Integer.valueOf(id));
		
		model.addAttribute("avg",avg);
		model.addAttribute("product",product);
		model.addAttribute("product_access",product_access1);
		return "user/product_detail";
	}
	@PostMapping("add")
	public String Review(Model model, @RequestParam("productid") String id, @RequestParam("content") String content,@RequestParam("radio") String radioValue) throws ParseException {
		Integer start_rate = null;
			if(radioValue.equals("1")) {
				start_rate = 1;
			}else if (radioValue.equals("2")) {
				start_rate = 2;
			}else if (radioValue.equals("3")) {
				start_rate = 3;
			}else if (radioValue.equals("4")) {
				start_rate = 4;
			}else if (radioValue.equals("5")) {
				start_rate = 5;
			}
		Optional<product> Oproduct = productService.FindById(id);
		product product = Oproduct.orElse(new product());
		product_access product_access = new product_access();
		users user = (users) HttpSession.getAttribute(sessionAttribute.CURRENT_USER);
		product_access.setUsers(user);
		product_access.setProduct(product);
		product_access.setDate_create(new Date());
		product_access.setContent(content);
		product_access.setStart_rate(start_rate);
		ProductAssessService.Create(product_access);
		return "redirect:/productdetail?productid="+id;
	}
}
