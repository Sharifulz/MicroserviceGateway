package com.exam.service;

import java.util.Map;

import com.exam.payload.CommonViewModel;

public interface IOrderService {

	Map<String, Object> saveOrder(CommonViewModel viewModel);

	Map<String, Object> getOrders();

}
	