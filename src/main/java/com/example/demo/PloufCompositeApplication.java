package com.example.demo;

import com.example.demo.repositorie.CoursUtilRepository;
import com.example.demo.repositorie.CoursUtilRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

@EnableEurekaClient
public class PloufCompositeApplication {

	public static final String COURS_SERVICE_URL = "http://PLOUFCOURS";

	public static final String UTIL_SERVICE_URL = "http://PLOUFMEMBRE";

	public static void main(String[] args) {
		SpringApplication.run(PloufCompositeApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){return new RestTemplate();}


	@Bean
	public CoursUtilRepository coursUtilRepository(){
		return new CoursUtilRepositoryImpl(COURS_SERVICE_URL,UTIL_SERVICE_URL);
	}

}
