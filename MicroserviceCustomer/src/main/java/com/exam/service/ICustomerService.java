package com.exam.service;

import java.util.Map;

import com.exam.model.CustomerModel;
import com.exam.payload.CommonViewModel;

public interface ICustomerService {

	public Map<String, Object> saveCustomer(CustomerModel customer);

	public Map<String, Object> getCustomers();

	public Map<String, Object> getCustomerById(CommonViewModel viewModel);
	
}

