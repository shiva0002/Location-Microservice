package com.movieticketsystem.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@SpringBootApplication
@EnableAspectJAutoProxy
@EnableDiscoveryClient
public class LocationApplication {
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(LocationApplication.class, args);

		
	}

}
