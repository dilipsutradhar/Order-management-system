package com.order.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.order.service.model.Orderr;

import feign.Headers;

@Headers("Content-Type: application/json")
@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface RestClientService {
    @RequestMapping(value = "/app2/item/service/fetch", method = RequestMethod.POST)
    Orderr saveTest(@RequestBody Orderr order);

	@RequestMapping(value = "/api2/v1/OrderItemService/create", method = RequestMethod.POST)
    Orderr save(@RequestBody Orderr order);
	
	@RequestMapping(value = "/api2/v1/OrderItemService/getAll", method = RequestMethod.GET)
	Iterable<Orderr> showAll();
	
	@RequestMapping(value = "/api2/v1/OrderItemService/show/{orderId}", method = RequestMethod.GET)
	Orderr showOne(@PathVariable(value = "orderId") int orderId);
}
