package com.sa.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bill")
public class BillGeneration {
	
	@Value("Pradise")
	private String hotelName;
	@Value("#{info.idlyPrice+info.dosaPrice+info.pohaPrice}")
	private Float totalPrice;
	
	@Autowired
	private ItemInfo info;

	@Override
	public String toString() {
		return "BillGeneration [hotelName=" + hotelName + ", totalPrice=" + totalPrice + ", info=" + info + "]";
	}
	
	

}
