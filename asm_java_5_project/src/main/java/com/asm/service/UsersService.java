package com.asm.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.asm.dto.userLogin;
import com.asm.model.users;

@Service
public interface UsersService {
	public 	Boolean 	Login(userLogin userLogin);
	public 	List<users> selectAll();
	public	users 		Create(users users);	
	public 	users 		Update(users users);
	public 	users 		Remove(users users);
	public 	users 		selectById(String username);
	public 	List<users> selectLikeFullName(String fullname);
	public 	users       selectByEmail(String email);
	public 	List<users> selectUserIsAdmin();
	public 	List<users> selectUserisUser();
	public 	List<users> selectUserRemoved();
	public 	List<users> selectUserisUserAndActive();
	public 	List<users> selectUserisUserAndRemoved();

	public users seclectByEmail(String email);
}
