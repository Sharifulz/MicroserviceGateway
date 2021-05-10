package com.exam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.ApiKeyEndpointsModel;
import com.exam.model.Student;
import com.exam.service.ApiKeyEndpointsService;

@RestController
public class ApiKeyController {

	@Autowired
	ApiKeyEndpointsService apiKeyEndpointsService;

	// http://localhost:9099/get_api_keys?apiKey=BDA123456789&endPoint=users_by_usernames
	@PostMapping("/get_api_keys")
	public ResponseEntity<List<ApiKeyEndpointsModel>> getApiKeys(HttpServletRequest request,
			@RequestParam(name = "apiKey") String apiKey, @RequestParam(name = "endPoint") String endPoint) {
		List<ApiKeyEndpointsModel> apiKeys = apiKeyEndpointsService.validateApiKey(apiKey, endPoint);
		System.out.println("Size-------------------> " + apiKeys.size());
		return new ResponseEntity<>(apiKeys, HttpStatus.OK);
	}

	// http://localhost:9099/get_student?studentId=19VC21&isCacheable=true
	@GetMapping("/get_student")
	public ResponseEntity<Student> fetchStudent(@RequestParam(name = "studentId") String studentId,
			@RequestParam(name = "isCacheable") boolean isCacheable) throws InterruptedException {
		return new ResponseEntity<>(apiKeyEndpointsService.fetchStudent(studentId, isCacheable).get(), HttpStatus.OK);
	}

}
