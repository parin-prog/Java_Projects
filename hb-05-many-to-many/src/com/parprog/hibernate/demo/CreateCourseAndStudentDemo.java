package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Course;
import com.parprog.hibernate.demo.entity.Instructor;
import com.parprog.hibernate.demo.entity.InstructorDetail;
import com.parprog.hibernate.demo.entity.Review;
import com.parprog.hibernate.demo.entity.Student;


public class CreateCourseAndStudentDemo {

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
			
			
			// create a course
			Course tempCourse = new Course("Mean stack course...(Become Developer)");
			
			
			// save the course
			System.out.println("Saving the Course...");
			session.save(tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("Peter","Parker","peterparker@gmail.com");
			Student tempStudent2 = new Student("Jony","Bairstow","jonnyjonyyespapa@gmail.com");
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the course
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved Course   :    "+tempCourse.getStudents());
			
			
			
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

