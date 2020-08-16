package com.order.service.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.RestClientService;
import com.order.service.model.OrderItem;
import com.order.service.model.Orderr;

@RestController
public class OrderServiceController {
    @Autowired
    RestClientService restClientService;

    @RequestMapping(value = "/app1/order/service/show", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Orderr> show() {
    	Orderr orderr = new Orderr();
    	orderr.setCustomerName("DilipSutradhar");
    	orderr.setOrderId(1);
    	//orderr.setOrderdate(2020-08-17);
    	orderr.setShippingAddress("105-Banjara Hills Hydrabad,pin-794106");
    	orderr.setOrderItem(new OrderItem());
    	orderr.setTotalPrice(1000);
    	
    	Orderr order=restClientService.saveTest(orderr);
    	return new ResponseEntity(order, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/app1/order/service/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Orderr> save(@Valid @NotEmpty @RequestBody Orderr orderr) throws Exception{
    	restClientService.save(orderr);
    	return new ResponseEntity(null, HttpStatus.CREATED);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
    
    
    @RequestMapping(value = "/app1/order/service/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Orderr> showAll() {
    	
    	Iterable<Orderr> order=restClientService.showAll();
    	return new ResponseEntity(order, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/app1/order/service/show/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Orderr> showOne(@Valid @NotEmpty @PathVariable(value = "orderId") int orderId) {
    	
    	Orderr order=restClientService.showOne(orderId);
    	if (order == null) {
            return new ResponseEntity<Orderr>(order, HttpStatus.NOT_FOUND);
        }
    	return new ResponseEntity(order, HttpStatus.OK);
    }
    
    
    
}
