package com.exam.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.exam.model.ApiKeyEndpointsModel;
import com.exam.model.Student;
import com.exam.repository.IApiKeyDao;

@Service
public class ApiKeyEndpointsService {

	@Autowired
	IApiKeyDao apiKeyDao;

	// @CacheEvict(value = "twenty-second-cache", key =
	// "'StudentInCache'+#studentId", condition = "#isCacheable == null ||
	// !#isCacheable", beforeInvocation = true)
	@Cacheable(value = "twenty-second-cache", key = "'StudentInCache'+#studentId", condition = "#isCacheable != null && #isCacheable")
	public Optional<Student> fetchStudent(String studentId, boolean isCacheable) throws InterruptedException {
		Thread.sleep(4000);
		return Arrays
				.asList(new Student("19VC21", "John", "Wayne", "11"), new Student("19VC22", "Mary", "Jane", "11"),
						new Student("19VC23", "Peter", "Parker", "11"))
				.stream().filter(t -> t.getId().equalsIgnoreCase(studentId)).findFirst();
	}

	@Cacheable(value = "twenty-second-cache", key = "'ApiKeyInCache'+#apiKey")
	public List<ApiKeyEndpointsModel> validateApiKey(String apiKey, String endpoint) {
		return apiKeyDao.findByApiKeyAndEndpoint(apiKey, endpoint);
	}

}
