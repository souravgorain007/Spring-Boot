package com.sa;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.sa.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProject1DependencyInjectionApplication {
	
	@Bean(name="ldt")
	@Scope("prototype")
	public LocalDateTime createLocalDateTime() {
		//creating dependent class object
		System.out.println("BootProject1DependencyInjectionApplication.createLocalDateTime()");
		LocalDateTime ldt=LocalDateTime.now();
		return ldt;
		
	}
	
	@Bean(name="ldt1")
	@Scope("prototype")
	//@Primary
	public LocalDateTime createLocalDateTime2() {
		//creating dependent class object
		System.out.println("BootProject1DependencyInjectionApplication.createLocalDateTime()");
		LocalDateTime ldt1=LocalDateTime.now();
		return ldt1;
		
	}

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(BootProject1DependencyInjectionApplication.class, args);
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		String result=generator.generateWishMessage("Sourav Gorain");
		System.out.println(result);
		WishMessageGenerator generator1=ctx.getBean("wmg",WishMessageGenerator.class);
		
		System.out.println(generator.hashCode()+"   "+generator1.hashCode());
	}

}
