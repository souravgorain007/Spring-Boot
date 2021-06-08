package com.sa.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	@Autowired
	@Qualifier("ldt1")
	private LocalDateTime date;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.WishMessageGenerator()");
	}
	
	public String generateWishMessage(String name) {
		
		int hours=date.getHour();
		
		if(hours < 12)
			return "GOOD MORNING ::"+name;
		else if(hours < 16)
			return "GOOD AFTERNOON ::"+name;
		else if(hours < 20)
			return "GOOD EVENING ::"+name;
		else
			return "GOOD NIGHT ::"+name;
			
	}
	

}
