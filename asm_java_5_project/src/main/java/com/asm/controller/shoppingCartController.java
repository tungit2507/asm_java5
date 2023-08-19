package com.asm.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.constant.sessionAttribute;
import com.asm.model.cart_item;
import com.asm.model.orders;
import com.asm.model.orders_items;
import com.asm.model.product;
import com.asm.model.shopping_cart;
import com.asm.model.users;
import com.asm.service.CartItemService;
import com.asm.service.OrderItemsService;
import com.asm.service.OrdersService;
import com.asm.service.ProductsService;
import com.asm.service.ShoppingCartService;
import com.asm.until.SendMail.EmailDetails;
import com.asm.until.SendMail.EmailService;
import com.asm.until.pdf.CreatePDF;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "cart")
public class shoppingCartController {
	
	@Autowired
	CartItemService cartItemService;
	@Autowired
	ProductsService productsService;
	@Autowired 
	ShoppingCartService cartService;
	@Autowired
	EmailService emailService;
	@Autowired
	HttpSession session;
	@Autowired
	OrdersService ordersService;
	@Autowired
	OrderItemsService itemsService;
	
	
	@GetMapping("")
	public String shoppingCartForm(Model model) {
		List<cart_item> list = cartItemService.selectByCurrentUser();
		shopping_cart shopping = (shopping_cart) cartService.selectByCurrentUser();
		Double sum = 0.0;
		for (cart_item cart_item : list) {
			sum += cart_item.getQuantity()*cart_item.getProduct().getPrice();
		}
		model.addAttribute("sum",sum);
		model.addAttribute("shopping",shopping);
		model.addAttribute("list", list);
		return "user/shoppingCart";
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	public String addToCart(@RequestParam("productId") String productID, @RequestParam("quantity") Integer quantity  ) {
		Optional<product> product= productsService.FindById(productID);
		product product2 =  product.orElse(new product());
		shopping_cart shopping_cart = cartService.selectByCurrentUser();
		
		cart_item cart_item = new cart_item(); 
		
		cart_item.setProduct(product2);
		cart_item.setShopping_cart(shopping_cart);
		cart_item.setQuantity(quantity);
		cartItemService.Create(cart_item);
		return "Thêm Vào Giỏi Hàng Thành Công";
	}
	
	@PostMapping("/remove")
	@ResponseBody
	public String removeCartItem(@RequestParam("cartItemId") Integer cartItemId) {
		cart_item cart_item  = cartItemService.selectById(cartItemId);
		System.out.println(cartItemId);
		if(cart_item != null) {
			cartItemService.Remove(cart_item);
		}else {
			System.out.println("Chưa Đăng Nhập");
		}
		return "Xóa Thành Công";
	}
	
	
	@GetMapping("/checkout")
	public String checkout() throws DocumentException {	
		
		List<cart_item> list = cartItemService.selectByCurrentUser();
		users users =  (com.asm.model.users) session.getAttribute(sessionAttribute.CURRENT_USER);
		

		Double Sum = 0.0;
		for (cart_item cart_item : list) {
			Sum += (Double) (cart_item.getProduct().getPrice() * cart_item.getQuantity());
		}
		
		
		orders orders = new orders();
		orders.setUsers(users);
		orders.setTotal(Sum);
		orders.setStatus("Chưa Thanh Toán");
		ordersService.Create(orders);
		
		for (cart_item cart_item : list) {
			orders_items items = new orders_items();
			items.setProduct(cart_item.getProduct());
			items.setPrice(cart_item.getProduct().getPrice());
			items.setOrders(orders);
			itemsService.Create(items);
		}

		// create PDF
		Document document =  CreatePDF.CreatePDFGenerator("checkout");
		document.add(new Paragraph("Your Order has : "));
		for (cart_item cart_item : list) {			
			document.add(new Paragraph("x" + cart_item.getQuantity() + "   " + cart_item.getProduct().getNames() + "   $" + cart_item.getQuantity()*cart_item.getProduct().getPrice()));
		}
		document.add(new Paragraph("recipient is : " + users.getFullname())); 
		document.add(new Paragraph("Your Phone is : " + users.getPhone_number()));
		document.add(new Paragraph("Your Address is :" + users.getAdress()));
		
		
		document.add(new Paragraph("You need pay : " + Sum + "$ for this orders. Please pay when you recieve our product!!."));
		document.add(new Paragraph("Thank you"));
		document.close();

		// Send Email
		EmailDetails details = new EmailDetails();
		details.setRecipient(users.getEmail());
		details.setSubject("Thông tin thanh toán");
		details.setMsgBody("Đây là file PDF gồm những chi tiết đặt hàng. Bạn vui lòng kiểm tra, nếu có sai xót xin liên hệ với chúng tôi");
		details.setAttachment("checkout.pdf");
		emailService.sendMailWithAttachment(details);
		return "redirect:../index";
	}
	
	
}
