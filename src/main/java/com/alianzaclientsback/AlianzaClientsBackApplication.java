package com.alianzaclientsback;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alianzaclientsback.repository.ClientRepository;

@SpringBootApplication
public class AlianzaClientsBackApplication {
	@Autowired
	ClientRepository clientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AlianzaClientsBackApplication.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	clientRepository.initializeListClient();
	      };
	   }

}
