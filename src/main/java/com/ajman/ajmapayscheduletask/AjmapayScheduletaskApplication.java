package com.ajman.ajmapayscheduletask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = { "com.ajman" })
@EnableConfigurationProperties(AppProperties.class)
@EnableJpaRepositories(basePackages = { "com.ajman" })
public class AjmapayScheduletaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjmapayScheduletaskApplication.class, args);
	}

}
