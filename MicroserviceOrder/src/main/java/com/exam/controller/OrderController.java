package com.exam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.payload.CommonViewModel;
import com.exam.service.IOrderService;

@RestController
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	@PostMapping("/save_order")
	public ResponseEntity<Map<String, Object>> saveOrder(HttpServletRequest request, @RequestBody CommonViewModel viewModel){
		
		Map<String, Object> data = orderService.saveOrder(viewModel);
		ResponseEntity<Map<String,Object>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);	
		return responseEntity;
	}
	
	@PostMapping("/get_orders")
	public ResponseEntity<Map<String, Object>> getOrders(HttpServletRequest request){
		
		Map<String, Object> data = orderService.getOrders();
		ResponseEntity<Map<String,Object>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);	
		return responseEntity;
	}
	
}
