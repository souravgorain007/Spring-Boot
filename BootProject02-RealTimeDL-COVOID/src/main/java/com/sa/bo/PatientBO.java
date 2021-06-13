package com.sa.bo;

import java.util.Date;

import lombok.Data;

@Data
public class PatientBO {
	
	private Integer patientNo;
	private String patientName;
	private String patientAddress;
	private String hospitalName;
	private Date admitDate;
	private Date releaseDate;
	private Float totalCost;
	private Integer noDaysHospitalized;
	

}
