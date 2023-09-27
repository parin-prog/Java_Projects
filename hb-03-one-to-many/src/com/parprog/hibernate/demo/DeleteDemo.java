package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

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
			
			// start a transation
			session.beginTransaction();
			
			
			// get instructor by primary key/ id
			int theId=2;
			Instructor tempInstructor= session.get(Instructor.class,theId);
			
			System.out.println("Delete Instructor:"+tempInstructor);
			
			// delete the instructors
			// cascadeType is all so it will be delete
			if(tempInstructor != null) {
				
				System.out.println("deleting");
				session.delete(tempInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}

