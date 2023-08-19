package com.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asm.model.orders;
import com.asm.model.product;
import com.asm.model.product_access;

@Service
public interface ProductAssessService {
	public 	List<product_access>	selectAll();
	public	product_access 			Create(product_access product_access);	
	public 	product_access 			Update(product_access product_access);
	public 	product_access 			Remove(product_access product_access);
	public List<product_access> findByProduct(product product);
	public Integer avgStart_rate(Integer id);
	public Integer countProductAccess(String id);
}
