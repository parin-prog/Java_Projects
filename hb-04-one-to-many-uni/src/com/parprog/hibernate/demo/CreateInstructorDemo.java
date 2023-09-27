package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Course;
import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .addAnnotatedClass(Course.class)
				               .buildSessionFactory();
	
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			// Create Object
			Instructor tempInstructor = new Instructor("Harsh","Patel","harshpatel12@yahoo.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("Youtube:@Gaming","Playing Football");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			// start a transation
			session.beginTransaction();
			
			System.out.println("Saving instructor:"+tempInstructor);
			// Save session
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

