package com.parprog.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.parprog.springdemo")
@PropertySource("classpath:sport.properties")
public class JavaConfig {

	//define a bean for SadFortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//define a bean for SwimCoach and Inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
