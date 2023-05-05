package com.example.partypad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PartypadApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartypadApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer () {
//
//		System.out.println("corsConfigurer  Run 20230401");
//		return new WebMvcConfigurer() {
//
//			public void addCorsMappings (CorsRegistry registry) {
//
//				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3001") ;
//
//			}
//
//		} ;
//	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("http://localhost:3001")
//						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//						.allowedHeaders("*")
//						.exposedHeaders("Access-Control-Allow-Origin")
//						.allowCredentials(true)
//						.maxAge(3600);
//			}
//		};
//	}



}
