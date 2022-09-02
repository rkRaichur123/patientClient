package com.example.ms.patientClient.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientServiceImpl implements PatientService{

	@SuppressWarnings("rawtypes")
	@Autowired
    private CircuitBreakerFactory circuitBreakerFactory;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public String getPatientDetails() {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		String url = "http://localhost:8080/api/user/getUserDetails";

		return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class), 
			      throwable -> getDefaultAlbumList());
	}

	private String getDefaultAlbumList() {
		// TODO Auto-generated method stub
		return "Error from fallback method form Pateint API";
	}


	
}
