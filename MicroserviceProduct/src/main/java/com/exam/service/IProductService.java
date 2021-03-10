package com.exam.service;

import java.util.Map;

import com.exam.model.ProductModel;
import com.exam.payload.CommonViewModel;

public interface IProductService {

	Map<String, Object> saveProduct(ProductModel product);

	Map<String, Object> getProducts();

	Map<String, Object> getProductById(CommonViewModel viewModel);

}
