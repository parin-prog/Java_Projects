package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Course;
import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;


public class EagerLazyDemo {

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
			
			int theId=1;
			
			// get the instructor from db
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor data: "+tempInstructor);
			
			System.out.println("Courses data:"+tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("\nAlert:Session ends here !!!!\n");
			System.out.println("Courses data:"+tempInstructor.getCourses());
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

