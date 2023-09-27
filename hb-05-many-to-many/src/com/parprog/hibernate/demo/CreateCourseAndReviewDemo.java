package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Course;
import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;
import com.parprog.hibernate.demo.entity.Review;


public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Instructor.class)
				               .addAnnotatedClass(InstructorDetail.class)
				               .addAnnotatedClass(Course.class)
				               .addAnnotatedClass(Review.class)
				               .buildSessionFactory();
	
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// start a transation
			session.beginTransaction();
			
			
			// create a course
			Course tempCourse = new Course("Mern stack course...(Become Developer)");
			
			// add review in it
			tempCourse.addReview(new Review("i like it it's amazing wiwww....!!!"));
			tempCourse.addReview(new Review("i love it it's amazing wowww....!!!"));
			tempCourse.addReview(new Review("it's amazing woooowww....!!!"));
			
			// save the course
			System.out.println("Saving the Course...");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
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

