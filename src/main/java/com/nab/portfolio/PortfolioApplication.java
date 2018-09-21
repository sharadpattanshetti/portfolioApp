package com.nab.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/**
 * Application starter class for Portfolio App.
 * 
 * Created by Sharad
 */


@SpringBootApplication
@EnableJpaAuditing
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
}
