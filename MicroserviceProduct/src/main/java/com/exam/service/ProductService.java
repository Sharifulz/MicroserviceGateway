package com.exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.ProductModel;
import com.exam.payload.CommonViewModel;
import com.exam.repository.IProductDao;

@Service
public class ProductService implements IProductService {

	@Autowired
	IProductDao productDao;
	
	@Override
	public Map<String, Object> saveProduct(ProductModel product) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		ProductModel prod = productDao.save(product);
		data.put("data", prod);
		return data;
	}

	@Override
	public Map<String, Object> getProducts() {
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<ProductModel> prodList = productDao.findAll();
		data.put("data", prodList);
		return data;
	}

	@Override
	public Map<String, Object> getProductById(CommonViewModel viewModel) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		Optional<ProductModel> prod = productDao.findById(UUID.fromString(viewModel.getProductId()));
		
		if (prod.isPresent()) {
			data.put("data", prod);
			data.put("status", "successful");
		}else {
			data.put("data", new ArrayList<>());
			data.put("status", "failure");
		}
		return data;
	}
	


}
