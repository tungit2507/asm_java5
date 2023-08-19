package com.asm.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.asm.until.SendMail.EmailDetails;
import com.asm.until.SendMail.EmailServiceImpl;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.asm.constant.sessionAttribute;
import com.asm.dto.userLogin;
import com.asm.model.users;
import com.asm.service.UsersService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("account")
public class accountController {
	@Autowired
	UsersService usersService;
	@Autowired
	EmailServiceImpl emailIml;
	@Autowired
	HttpSession session;
	@Autowired 
	ServletContext app;
	

	@GetMapping("login")
	public String Login() {
		return "user/testlogin";
	}

	@PostMapping("login")
	public String loginPost(Model model,@RequestParam("username") String username, @RequestParam("password") String password) {
		userLogin account  = new userLogin(username,password);
		Boolean request  = usersService.Login(account);
		if(request == false) {
			model.addAttribute("message", "Sai Tên Tài Khoản Hoặc Mật Khẩu");
			return "user/testlogin";
		}else {
			return "redirect:../index";
		}
	}

	@GetMapping("signUp")
	public String SignUp() {
		return "user/signuptest";
	}
	
	@PostMapping("signUp")	
	public String SignUpPost(Model model,
			@RequestParam("username") String username,
			@RequestParam("fullname") String fullname,
			@RequestParam("email") String email,
			@RequestParam("phone_number") String phone_number,
			@RequestParam("adress") String adress,
			@RequestParam("password") String password,
			@RequestParam("cpassword") String cpassword,
			@RequestParam("photo") MultipartFile photo) throws IOException
	{
		users checkUsername =  usersService.selectById(username);
		if(checkUsername==null) {
			users checkMail =  usersService.selectByEmail(email);
			if(checkMail==null) {
				BufferedImage image = ImageIO.read(photo.getInputStream());
				if(image!=null) {
					if(cpassword.equals(password)) {
						users users = new users();
						users.setUsername(username);
						users.setFullname(fullname);
						users.setEmail(email);
						users.setPhone_number(phone_number);
						users.setAdress(adress);
						users.setPassword(cpassword);
						users.setPhoto(photo.getOriginalFilename());
						String fileName = photo.getOriginalFilename();
						File file2 = new File(app.getRealPath("/templates/img/user/")+ fileName);
						photo.transferTo(file2);
						usersService.Create(users);
						session.setAttribute(sessionAttribute.CURRENT_USER,users);
					}else {
						model.addAttribute("message","Mật Khẩu Không Trùng Khớp");
						return "user/signuptest";
					}
				}
				else {
					model.addAttribute("message","Phải Chọn File là hình ảnh");
					return "user/signuptest";
				}
				
			}else {
				model.addAttribute("message","Email đã có người sử dụng");
				return "user/signuptest";
			}
		}else {
			model.addAttribute("message", "username đã có người sử dụng");
			return "user/signuptest";
		}
		
		return "redirect:../index";
	}

	@GetMapping("changePassword")
	public String changePassword() {
		return "user/changePass";
	}

	@PostMapping("changePassword")
	public String changePasswordPost(Model model, @RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword,  @RequestParam("confirmPassword") String confirmPassword ) {
		users users = (com.asm.model.users) session.getAttribute(sessionAttribute.CURRENT_USER);
		if(users.getPassword().equals(oldPassword)) {
			if(newPassword.equals(confirmPassword)) {
				users.setPassword(confirmPassword);
				usersService.Update(users);
				session.setAttribute(sessionAttribute.CURRENT_USER, users);
				return  "redirect:../index";
			}else {
				model.addAttribute("message","Vui Lòng Xác Nhận Lại Mật khẩu");
				return "user/changePass";
			}
		}else {
			model.addAttribute("message","Sai Mật Khẩu Hiện Tại");
			return "user/changePass";
		}
	}


	@GetMapping("logOut")
	public String logOut() {
		session.setAttribute(com.asm.constant.sessionAttribute.CURRENT_USER, null);
		return  "redirect:../index";
	}
	@GetMapping("fillOTP")
	public String fillOTP() {
		return  "user/fillOTP";
	}
	@PostMapping("fillOTP")
	public String fillOTP(Model model,@RequestParam("OTP") String code) {
		if(code.equalsIgnoreCase((String) session.getAttribute(sessionAttribute.code))){
			String newPassword = RandomString.make(10);
			EmailDetails details = new EmailDetails();
			details.setRecipient((String) session.getAttribute(sessionAttribute.EMAIL_FORGOT_PASSWORD));
			details.setSubject("Your Password");
			details.setMsgBody("Your Password is : " + newPassword );
			emailIml.sendSimpleMail(details);
			users users = (com.asm.model.users) session.getAttribute(sessionAttribute.USER_FORGOT_PASSWORD);
			users.setPassword(newPassword);
			usersService.Update(users);
			session.setAttribute(sessionAttribute.CURRENT_USER, users);
			return "redirect:../index";
		}

		else
			model.addAttribute("message","Sai OTP");
		return  "user/fillOTP";
	}
	@GetMapping("forgotPass")
	public String forgotPass() {
		return "user/forgotPass";
	}

	@PostMapping("forgotPass")
	public String forgotPass(Model model,
							 @RequestParam("email") String emailss) {
		users users = usersService.seclectByEmail(emailss);

		if(users!=null){
			String codeOTP = RandomString.make(6);
			EmailDetails details = new EmailDetails(emailss,codeOTP,"Ma OTP",null);
			emailIml.sendSimpleMail(details);
			session.setAttribute(sessionAttribute.code,codeOTP);
			System.out.println(sessionAttribute.code);
			session.setAttribute(sessionAttribute.USER_FORGOT_PASSWORD, users);
			session.setAttribute(sessionAttribute.EMAIL_FORGOT_PASSWORD, emailss);
			return "redirect:./fillOTP";
		}
	else {
		model.addAttribute("message","Email không trùng khớp với tài khoản!");
		return "user/forgotPass";
		}
	}


}
