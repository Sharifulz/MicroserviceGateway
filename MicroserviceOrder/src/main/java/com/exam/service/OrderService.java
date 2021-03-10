package com.exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exam.model.OrderModel;
import com.exam.payload.CommonViewModel;
import com.exam.repository.IOrderDao;
import com.exam.util.ICommonApiService;
import com.exam.viewmodel.CustomerModel;
import com.exam.viewmodel.ProductModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderService implements IOrderService {

	@Autowired
	ObjectMapper objectMapper;
	
	@Value("${get_customer_by_id}")
	String UrlGetCustomerById;
	
	@Value("${get_product_by_id}")
	String UrlGetProductById;
	
	@Autowired
	IOrderDao orderDao;
	
	@Autowired
	ICommonApiService commonApiService;

	@Override
	public Map<String, Object> saveOrder(CommonViewModel viewModel) {
		Map<String, Object> data = new HashMap<String, Object>();
		CustomerModel customer = new CustomerModel();
		ProductModel product = new ProductModel();
		OrderModel order = new OrderModel();
		
		Map<String, Object> customerResp = commonApiService.getResponseMap(viewModel, UrlGetCustomerById);
		
		if (customerResp!=null) {
			customer = objectMapper.convertValue(customerResp.get("data"), CustomerModel.class);
			if (customer!=null) {
				System.out.println("-=-------------------------> "+ customer.getCustomerName());
				order.setCustomerId(customer.getId());
				order.setCustomerCode(customer.getCustomerCode());
				order.setCustomerName(customer.getCustomerName());
			}
		}
		
		Map<String, Object> productMap = commonApiService.getResponseMap(viewModel, UrlGetProductById);
		
		if (productMap!=null) {
			product = objectMapper.convertValue(productMap.get("data"), ProductModel.class);
			if (product!=null) {
				System.out.println("-=-------------------------> "+ product.getProductName());
				order.setProductId(product.getId());
				order.setProductCode(product.getProductCode());
				order.setProductName(product.getProductName());
				order.setProductPrice(product.getProductPrice());
			}
		}
		
		if (order!=null) {
			OrderModel ord = orderDao.save(order);
			if (ord!=null) {
				data.put("data", ord);
			}else {
				data.put("data", new ArrayList<>());
			}
		}
		
		return data;
	}

	@Override
	public Map<String, Object> getOrders() {
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<OrderModel> orderList = orderDao.findAll();
		data.put("data", orderList);
		return data;
	}

}
