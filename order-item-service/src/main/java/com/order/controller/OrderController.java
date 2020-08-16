package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.doa.OrderItemDoa;
import com.order.model.Orderr;
import com.order.service.OrderItemService;

@RestController
public class OrderController {

	@Autowired
	OrderItemService orderItemServices;
	@Autowired
	OrderItemDoa orderItemDoa;

	@RequestMapping(value = "/app2/item/service/fetch", method = RequestMethod.POST)
	@ResponseBody
	public Orderr saveTest(@RequestBody Orderr order) {
		return order;
	}

	@RequestMapping(value = "/api2/v1/OrderItemService/create", method = RequestMethod.POST)
	public ResponseEntity<Orderr> save(@RequestBody Orderr input) {
		orderItemServices.save(input);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api2/v1/OrderItemService/getAll", method = RequestMethod.GET)
	public ResponseEntity<?> showAll() {
		Iterable<Orderr> order = orderItemDoa.findAll();

		if (order == null) {
			return new ResponseEntity<Orderr>((Orderr) null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(order, HttpStatus.OK);
	}

	@RequestMapping(value = "/api2/v1/OrderItemService/show/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<Orderr> show(
			@PathVariable(value = "orderId") int orderId) {

		Orderr order = orderItemDoa.findById(orderId);

		if (order == null) {
			return new ResponseEntity<Orderr>(order, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(order, HttpStatus.OK);
	}

}
