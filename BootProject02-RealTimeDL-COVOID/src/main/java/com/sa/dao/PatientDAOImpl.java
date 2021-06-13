package com.sa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sa.bo.PatientBO;

@Repository("patientDAO")
public class PatientDAOImpl implements IPatientDAO {
	
	private static final String GET_PATIENT_HOSPITALNAME="SELECT * FROM COVOIDPATIENT WHERE HOSPITALNAME IN ";
	
	@Autowired
	private DataSource datasource;

	@Override
	public List<PatientBO> getPatientByHospitalName(String name) throws Exception {
		List<PatientBO> listBO=null;
		PatientBO bo=new PatientBO();
		try(Connection con=datasource.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(GET_PATIENT_HOSPITALNAME+name)){
			listBO=new ArrayList();
			while(rs.next()) {
				bo.setPatientNo(rs.getInt(1));
				bo.setPatientName(rs.getString(2));
				bo.setPatientAddress(rs.getString(3));
				bo.setHospitalName(rs.getString(4));
				bo.setAdmitDate(rs.getDate(5));
				bo.setReleaseDate(rs.getDate(6));
				bo.setTotalCost(rs.getFloat(7));
				bo.setNoDaysHospitalized(rs.getInt(8));
				listBO.add(bo);
			}
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}//catch
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}//catch
		return listBO;
	}//getPatientByHospitalName()

}//class
