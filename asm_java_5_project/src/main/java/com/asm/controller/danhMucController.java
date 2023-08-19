package com.asm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.model.danhmuc;
import com.asm.repository.danhMucRepo;

@Controller
public class danhMucController {
	@Autowired
	danhMucRepo danhMucRepo;
	
	@GetMapping("danhMuc")
	public String index(Model model) {
		List<danhmuc> listDanhMuc = 	danhMucRepo.findAll();
		model.addAttribute("listDanhMuc", listDanhMuc);
		return "admin/danhMuc";
	}
	@GetMapping("danhMuc/add")
	public String add(Model model,@RequestParam("id") String id, @RequestParam("name") String name ) {
		danhmuc danhmuc = new danhmuc(id, name, "");
		danhMucRepo.save(danhmuc);
		return "redirect:../danhMuc";
	}
	
	@GetMapping("danhMuc/edit")
	public String Edit(Model model,@RequestParam("id") String id, @RequestParam("name") String name ) {
		Optional<danhmuc> danhmuc = danhMucRepo.findById(id);
		danhmuc danhmuc2 = danhmuc.orElse(null);
		if(danhmuc2!=null) {
			System.out.println("co");
			danhmuc2.setName(name);
		}else {
			model.addAttribute("message", "khong co id nao trung khop");
		}
		return "redirect:../danhMuc";
	}
	
	@GetMapping("danhMuc/delete")
	public String delete(Model model,@RequestParam("id") String id) {
		Optional<danhmuc> danhmuc = danhMucRepo.findById(id);
		danhmuc danhmuc2 = danhmuc.orElse(null);
		if(danhmuc2!=null) {
			danhMucRepo.delete(danhmuc2);
		}else {
			model.addAttribute("message", "khong co id nao trung khop");
		}
		return "redirect:../danhMuc";
	}
	@GetMapping("writeForm")
	public String writeForm(Model model, @RequestParam("id") String id) {
		List<danhmuc> listDanhMuc = 	danhMucRepo.findAll();
		model.addAttribute("listDanhMuc", listDanhMuc);
		Optional<danhmuc> danhmuc = danhMucRepo.findById(id);
		danhmuc danhmuc2 = danhmuc.orElse(null);
		if(danhmuc2!=null) {
			model.addAttribute("id", danhmuc2.getId());
			model.addAttribute("name", danhmuc2.getName());
		}else {
			model.addAttribute("message", "khong co id nao trung khop");
		}
		return "admin/danhMuc";
	}
}
