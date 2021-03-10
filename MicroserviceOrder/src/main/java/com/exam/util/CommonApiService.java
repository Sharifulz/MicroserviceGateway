package com.exam.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exam.payload.CommonViewModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CommonApiService implements ICommonApiService{
	
		@Autowired
		RestTemplate restTemplate;
		
		@Override
		public Map<String, Object> getResponseMap(CommonViewModel commonViewModel, String url) {
		    ResponseEntity<Map> result= null;
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
			
		    final HttpEntity<CommonViewModel> request = new HttpEntity<>(commonViewModel, headers);
		    ObjectMapper mapper = new ObjectMapper(); 
		    Map<String, Object> responseModel = new HashMap<String, Object>();
		   try {
				result = restTemplate.postForEntity(url, request, Map.class);
				System.out.println(result);
				if (result.getBody().get("status").equals("successful")) {
		        	try { 
		        		responseModel = mapper.convertValue(result.getBody(), new TypeReference<Map<String, Object>>(){});
		        		return responseModel;
		        	} catch (Exception e) {
		        		e.printStackTrace();
						return null;
					} 
				}else {
					return null;
				} 		
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

} 
 

