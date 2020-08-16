package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.doa.OrderItemDoa;
import com.order.model.Orderr;
@Service
public class OrderItemService {

	@Autowired
	OrderItemDoa orderItemDoa;

	public OrderItemService(OrderItemDoa orderItemDoa) {
		this.orderItemDoa = orderItemDoa;
	}

	public void save(Orderr input) {

		orderItemDoa.save(input);
	}

}
