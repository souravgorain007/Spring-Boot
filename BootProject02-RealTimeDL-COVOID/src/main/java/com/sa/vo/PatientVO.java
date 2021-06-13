package com.sa.vo;

import lombok.Data;

@Data
public class PatientVO {
	
	private String serialNo;
	private String patientNo;
	private String patientName;
	private String patientAddress;
	private String hospitalName;
	private String admitDate;
	private String releaseDate;
	private String totalCost;
	private String noDaysHospitalized;

}
