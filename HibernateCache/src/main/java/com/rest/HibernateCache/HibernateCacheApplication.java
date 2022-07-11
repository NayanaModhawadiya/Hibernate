package com.rest.HibernateCache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HibernateCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCacheApplication.class, args);
	}

}