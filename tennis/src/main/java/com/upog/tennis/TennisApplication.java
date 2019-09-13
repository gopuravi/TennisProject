package com.upog.tennis;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.upog.tennis.service.TennisInitService;

@SpringBootApplication
public class TennisApplication {
	
	@Autowired
	TennisInitService tennisInitService;

	public static void main(String[] args) {
		System.out.println("Application starting");
		SpringApplication.run(TennisApplication.class, args);
	}
	
	@Bean
	InitializingBean intitialize() {
	    return () -> {
	    	tennisInitService.initConnections();
	      };
	   } 

}

