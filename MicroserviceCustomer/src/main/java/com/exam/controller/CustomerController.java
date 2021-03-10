package com.exam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.CustomerModel;
import com.exam.payload.CommonViewModel;
import com.exam.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/save_customer")
	public ResponseEntity<Map<String, Object>> saveCustomer(HttpServletRequest request, @RequestBody CustomerModel customer){
		
		Map<String, Object> data = customerService.saveCustomer(customer);
		ResponseEntity<Map<String,Object>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);	
		return responseEntity;
	}
	
	@PostMapping("/get_customers")
	public ResponseEntity<Map<String, Object>> getCustomers(HttpServletRequest request){
		
		Map<String, Object> data = customerService.getCustomers();
		ResponseEntity<Map<String,Object>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);	
		return responseEntity;
	}
	
	@PostMapping("/get_customer_by_id")
	public ResponseEntity<Map<String, Object>> getCustomerById(HttpServletRequest request, @RequestBody CommonViewModel viewModel){
		
		Map<String, Object> data = customerService.getCustomerById(viewModel);
		ResponseEntity<Map<String,Object>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);	
		return responseEntity;
	}
	
}
