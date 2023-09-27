package com.parprog.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp3 {

	public static void main(String[] args) {
	    
		// load the spring configuration file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext3.xml");
		
		
		//retrieve bean from spring container
		
		Coach theCoach= context.getBean("myCoach",Coach.class);
		
		
		System.out.println(theCoach.getDailyWorkout());
		
	   context.close();
        
	}
}
