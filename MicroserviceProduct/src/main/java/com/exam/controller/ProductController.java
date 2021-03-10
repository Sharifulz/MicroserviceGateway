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

import com.exam.model.ProductModel;
import com.exam.payload.CommonViewModel;
import com.exam.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductService productService;
	
	@PostMapping("/save_product")
	public ResponseEntity<Map<String, Object>> saveProduct(HttpServletRequest request, @RequestBody ProductModel product){
		
		Map<String, Object> data = productService.saveProduct(product);
		ResponseEntity<Map<String,Object>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);	
		return responseEntity;
	}
	
	@PostMapping("/get_products")
	public ResponseEntity<Map<String, Object>> getProducts(HttpServletRequest request){
		
		Map<String, Object> data = productService.getProducts();
		ResponseEntity<Map<String,Object>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);	
		return responseEntity;
	}
	
	@PostMapping("/get_product_by_id")
	public ResponseEntity<Map<String, Object>> getProductById(HttpServletRequest request, @RequestBody CommonViewModel viewModel){
		
		Map<String, Object> data = productService.getProductById(viewModel);
		ResponseEntity<Map<String,Object>> responseEntity = null;
		
		responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);	
		return responseEntity;
	}
	
}
