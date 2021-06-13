package com.sa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sa.dto.PatientDTO;
import com.sa.service.IPatientService;
import com.sa.vo.PatientVO;

@Controller("patientController")
public class PatientController {
	
	@Autowired
	private IPatientService service;
	
	public List<PatientVO> showPatientDetailsByHospitalName(String[] name) throws Exception{
		
		List<PatientDTO> listDTO=service.fetchPatientDetailsByHospitalName(name);
		
		List<PatientVO> listVO=new ArrayList();
		listDTO.forEach(dto->{
			PatientVO vo=new PatientVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSerialNo(String.valueOf(dto.getSerialNo()));
			vo.setAdmitDate(String.valueOf(dto.getAdmitDate()));
			vo.setReleaseDate(String.valueOf(dto.getReleaseDate()));
			vo.setTotalCost(String.valueOf(dto.getTotalCost()));
			vo.setNoDaysHospitalized(String.valueOf(dto.getNoDaysHospitalized()));
			listVO.add(vo);
		});
		
		return listVO;
		
	}//showPatientDetailsByHospitalName()

}//class
