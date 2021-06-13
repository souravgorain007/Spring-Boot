package com.sa.service;

import java.util.List;

import com.sa.dto.PatientDTO;

public interface IPatientService {
	
	List<PatientDTO> fetchPatientDetailsByHospitalName(String[] name)throws Exception;
	
}
