package com.springbootapplication.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.springbootapplication")
@EntityScan(basePackages = "com.springbootapplication.entity")
@EnableJpaRepositories(basePackages = "com.springbootapplication.repositry")

public class ExcelDataTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelDataTransferApplication.class, args);
		System.out.println("testing of excel");
	}

}
