package com.sa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sa.beans.BillGeneration;

@SpringBootApplication
public class BootProject05ValueAnnoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProject05ValueAnnoApplication.class, args);
		BillGeneration generator=ctx.getBean("bill",BillGeneration.class);
		System.out.println("Data ::"+generator);
		//close
		((ConfigurableApplicationContext) ctx).close();
	}//main method 

}//class
