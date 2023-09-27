package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .buildSessionFactory();
	
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			// Create Object
			Instructor tempInstructor = new Instructor("Parin","Patel","parinvaghani001@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("Chad Darby","Computer Software");
			
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
			factory.close();
		}
	}

}

