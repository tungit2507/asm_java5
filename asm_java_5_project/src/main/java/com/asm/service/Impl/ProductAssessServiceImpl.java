package com.asm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.model.product;
import com.asm.model.product_access;
import com.asm.repository.productAssessRepository;
import com.asm.service.ProductAssessService;

@Service
public class ProductAssessServiceImpl implements ProductAssessService{
	@Autowired
	productAssessRepository	productAssessRepository;

	
	@Override
	public List<product_access> selectAll() {
		List<product_access> list = productAssessRepository.findAll();
		return list;
	}

	@Override
	public product_access Create(product_access product_access) {
		productAssessRepository.save(product_access);
		return product_access;
	}

	@Override
	public product_access Update(product_access product_access) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public product_access Remove(product_access product_access) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<product_access> findByProduct(product product) {
		
		List<product_access> list = productAssessRepository.findByProduct(product);
		return list;
	}

	@Override
	public Integer avgStart_rate(Integer id) {
		Integer avg = productAssessRepository.avgStart_rate(id);
		return avg ;
	}

	@Override
	public Integer countProductAccess(String id) {
		Integer count = productAssessRepository.countProductAccess(id);
		return count;
	}

}
