package com.sa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.bo.PatientBO;
import com.sa.dao.IPatientDAO;
import com.sa.dto.PatientDTO;

@Service("patientService")
public class PatientServiceImpl implements IPatientService {
	
	@Autowired
	private IPatientDAO dao;
	

	@Override
	public List<PatientDTO> fetchPatientDetailsByHospitalName(String[] name) throws Exception {
		//('AIIMS','APOLLO','MISSION HOSPITAL')
		StringBuilder builder=new StringBuilder("(");
		for(int i=0; i<name.length; i++) {
			if(i == name.length-1)
				builder.append("'"+name[i]+"')");
			else
				builder.append("'"+name[i]+"',");
		}//for
		String hospitalNames=builder.toString();
		List<PatientBO> listBO=dao.getPatientByHospitalName(hospitalNames);
		List<PatientDTO> listDTO=new ArrayList();
		listBO.forEach(bo->{
			PatientDTO dto=new PatientDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialNo(listDTO.size()+1);
			listDTO.add(dto);
			
		});
		return listDTO;
	}//fetchPatientDetailsByHospitalName()

}//class
