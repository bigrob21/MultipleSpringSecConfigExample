package com.paul.robert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.paul.robert.configs.WebConfigs;

@SpringBootApplication
@Import({WebConfigs.class})
public class MultipleSpringSecurityProfileControlledApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleSpringSecurityProfileControlledApplication.class, args);
	}
}
