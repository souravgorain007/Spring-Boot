package com.sa;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sa.controller.PatientController;
import com.sa.vo.PatientVO;

@SpringBootApplication
public class BootProject02RealTimeDlCovoidApplication {

	public static void main(String[] args) {
		//scanner
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Number :: ");
		int count=scn.nextInt();
		String names[]=null;
		if(count >= 1)
			names=new String[count];
		else {
			System.out.println("Invalid value !!!!");
			return;
		}
		
		for(int i=0; i<count ; i++) {
			System.out.println("Enter names ::"+(i+1));
			String name=scn.next();
			names[i]=name.toUpperCase();
		}//for
		
		ApplicationContext ctx=SpringApplication.run(BootProject02RealTimeDlCovoidApplication.class, args);
		PatientController controller=ctx.getBean("patientController",PatientController.class);
		
		try {
		   List<PatientVO> listVO=controller.showPatientDetailsByHospitalName(names);
		   System.out.println("Hospital name ::"+Arrays.toString(names));
		   listVO.forEach(vo->
			   System.out.println(vo));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	}// main method

}//class
