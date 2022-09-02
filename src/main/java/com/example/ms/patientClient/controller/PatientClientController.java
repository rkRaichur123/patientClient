package com.example.ms.patientClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms.patientClient.service.PatientServiceImpl;

@RestController
@RequestMapping("/api/patient")
public class PatientClientController {
	
	@Autowired
	PatientServiceImpl patientService;
	
	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "PatientClient is up and Running";
	}
	
	@GetMapping("/getPatientDetails")
	public String getPatientDetails() {
		return "Test Patient";
	}
	@GetMapping("/getPatientDetailsWithCB")
	public String getPatientDetailsWithCB() {
		return patientService.getPatientDetails();
	}
}
