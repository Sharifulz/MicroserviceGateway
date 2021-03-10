package com.exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.CustomerModel;
import com.exam.payload.CommonViewModel;
import com.exam.repository.ICustomerDao;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerDao customerDao;
	
	@Override
	public Map<String, Object> saveCustomer(CustomerModel customer) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		CustomerModel cust = customerDao.save(customer);
		data.put("data", cust);
		return data;
	}

	@Override
	public Map<String, Object> getCustomers() {
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<CustomerModel> custList = customerDao.findAll();
		data.put("data", custList);
		return data;
	}

	@Override
	public Map<String, Object> getCustomerById(CommonViewModel viewModel) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		Optional<CustomerModel> cust = customerDao.findById(UUID.fromString(viewModel.getCustomerId()));
		
		if (cust.isPresent()) {
			data.put("data", cust);
			data.put("status", "successful");
		}else {
			data.put("data", new ArrayList<>());
			data.put("status", "failure");
		}
		return data;
	}

}
