package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Course;
import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;


public class DeleteCourseDemo {

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
			
			// start a transation
			session.beginTransaction();
			
			int theId=10;
			
			// get the instructor from db
			Course tempCourse= session.get(Course.class, theId);
			Course tempCourse2= session.get(Course.class, theId+1);
			// Delete course
			session.delete(tempCourse);
			session.delete(tempCourse2);
			
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

