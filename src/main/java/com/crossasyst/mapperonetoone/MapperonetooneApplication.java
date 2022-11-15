package com.crossasyst.mapperonetoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MapperonetooneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapperonetooneApplication.class, args);
	}

}
