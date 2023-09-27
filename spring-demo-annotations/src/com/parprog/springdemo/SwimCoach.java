package com.parprog.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	
	public SwimCoach(FortuneService thefortuneService) {
		fortuneService=thefortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim Fast as U Can....!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

	
	public String getEmail() {
		return email;
	}

	
	public String getTeam() {
		return team;
	}

	
}
