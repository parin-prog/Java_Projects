package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;


public class DeleteInstructorDetail {

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
			
			// start a transaction
			session.beginTransaction();
		
			// get instructor by primary key/ id
			int theId=7;
			InstructorDetail tempInstructorDetail= session.get(InstructorDetail.class,theId);
			
			System.out.println("Instructor:"+tempInstructorDetail);
			System.out.println(tempInstructorDetail.getInstructor());
			// delete the instructors
			// cascadeType is all so it will be delete
			
			System.out.println("deleting the tempInstructorDetail: "+tempInstructorDetail);
			
			// this statement will delete only InstructorDetail data not Instructor data
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetail);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

