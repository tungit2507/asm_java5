package com.asm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.model.users;
import com.asm.service.UsersService;

@Controller
public class UserEditionController {
	@Autowired
	UsersService usersService;
	@GetMapping("editionUser")
	public String index(Model model) {
		List<users> listUserAdmin =  usersService.selectUserIsAdmin();
		model.addAttribute("listUserAdmin", listUserAdmin);
		List<users> listUser =  usersService.selectUserisUser();
		model.addAttribute("listUser", listUser);
		List<users> listUserRemove = usersService.selectUserisUserAndRemoved(); 
		model.addAttribute("listUserRemove", listUserRemove);
		List<users> listUserIsActive = usersService.selectUserisUserAndActive();
		model.addAttribute("listUserIsActive", listUserIsActive);
		
		return "admin/EditionUser";
	}
	
	@PostMapping("/userEdition/remove")
	@ResponseBody
	public String deleteUser(@RequestParam("username") String username) {
		users users = usersService.selectById(username);
		usersService.Remove(users);
		return "Xóa Thành Công";
	}
	
	@PostMapping("/userEdition/restore")
	@ResponseBody
	public String restoreUser(@RequestParam("username") String username) {
		users users = usersService.selectById(username);
		users.setIsactive(true);
		usersService.Update(users);
		return "Khôi Phục Thành Công";
	}
}
