package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Course;
import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;
import com.parprog.hibernate.demo.entity.Review;
import com.parprog.hibernate.demo.entity.Student;


public class AddCoursesforMaryDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .addAnnotatedClass(Course.class)
				               .addAnnotatedClass(Review.class)
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
	
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// start a transation
			session.beginTransaction();
			
		    int studentId=2;
		    
		    Student theStudent = session.get(Student.class, studentId);
			
		    session.save(theStudent);
		    
		    Course theCourse1 = new Course("Movie Making Course");
		    Course theCourse2 = new Course("Speed Running Course");
		    
		    theCourse1.addStudent(theStudent);
		    theCourse2.addStudent(theStudent);
			
		    session.save(theCourse1);
		    session.save(theCourse2);
		    System.out.println("Saved Courses  :  "+theStudent+"     "+theCourse1+"   "+theCourse2);
		    
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

