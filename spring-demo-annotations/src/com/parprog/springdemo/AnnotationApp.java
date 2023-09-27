package com.parprog.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context= 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		Coach theCoach= context.getBean("thatSillyCoach",Coach.class);
		
		
		//call a method to get daily fortune
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();

	}

}
