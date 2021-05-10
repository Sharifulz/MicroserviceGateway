package com.exam.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.ApiKeyEndpointsModel;

@Repository
public interface IApiKeyEndpointsDao extends JpaRepository<ApiKeyEndpointsModel, UUID> {

	public List<ApiKeyEndpointsModel> findByApiKeyAndEndpoint(String apiKey, String endpoint);

}
