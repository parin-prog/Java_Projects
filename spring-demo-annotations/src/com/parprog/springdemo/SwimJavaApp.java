package com.parprog.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaApp {

	public static void main(String[]args) { 

	
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		SwimCoach theCoach= context.getBean("swimCoach",SwimCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());

	}

}
