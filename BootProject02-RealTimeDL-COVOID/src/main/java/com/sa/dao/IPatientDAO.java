package com.sa.dao;

import java.util.List;

import com.sa.bo.PatientBO;

public interface IPatientDAO {
	
	List<PatientBO> getPatientByHospitalName(String name)throws Exception;

}
