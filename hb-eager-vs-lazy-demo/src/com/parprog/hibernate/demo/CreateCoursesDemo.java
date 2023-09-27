package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Course;
import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;


public class CreateCoursesDemo {

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
			Instructor tempInstructor= session.get(Instructor.class, theId);
			
			// create many courses
			Course tempCourse1= new Course("MERN Stack Web Development:NodeJs Expertise");
			Course tempCourse2= new Course("Deep Learning through TensorFlow:Advanced Skills");
			
			// add courses into Instructor through convenience add method 
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			System.out.println("Saving instructor:"+tempInstructor);
			// Save session
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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

