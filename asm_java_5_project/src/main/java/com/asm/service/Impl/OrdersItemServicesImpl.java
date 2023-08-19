package com.asm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.model.orders_items;
import com.asm.repository.orderItemRepository;
import com.asm.service.OrderItemsService;
@Service
public class OrdersItemServicesImpl implements OrderItemsService{

	@Autowired 
	orderItemRepository itemRepository;
	
	@Override
	public List<orders_items> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public orders_items Create(orders_items orders_items) {
		itemRepository.save(orders_items);
		return orders_items;
	}

	@Override
	public orders_items Update(orders_items orders_items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public orders_items Remove(orders_items orders_items) {
		// TODO Auto-generated method stub
		return null;
	}

}
