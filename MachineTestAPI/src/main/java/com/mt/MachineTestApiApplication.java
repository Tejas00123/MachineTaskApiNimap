package com.mt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.mt.entity")

public class MachineTestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MachineTestApiApplication.class, args);
	}

}
