package com.asm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.model.orders;
import com.asm.repository.ordersRepository;
import com.asm.service.OrdersService;
@Service
public class OrdersSeviceImpl implements OrdersService{

	@Autowired
	ordersRepository ordersRepository;
	
	@Override
	public List<orders> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public orders Create(orders orders) {
		ordersRepository.save(orders);
		return orders;
	}

	@Override
	public orders Update(orders orders) {
		return null;
	}

	@Override
	public orders Remove(orders orders) {
		// TODO Auto-generated method stub
		return null;
	}

}
