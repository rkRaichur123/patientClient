package com.example.ms.patientClient.PatientClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/patientClient")
@SpringBootApplication
public class PatientClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientClientApplication.class, args);
	}

	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "PatientClient is up and Running";
	}
}
