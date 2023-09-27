package com.parprog.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")

public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	//define default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	@PostConstruct
	public void Startup() {
		System.out.println("statup");
	}
	
	@PreDestroy
	public void Cleanup() {
		System.out.println("cleanup");
	}
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		
		fortuneService= theFortuneService;
	}
	*/

	
	@Override
	public String getDailyWorkout() {
		return "Practice your Backhand Volly";

	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getDailyFortune();
	}

	
}
