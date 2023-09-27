package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
	
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId=3;
			// MY NEW CODE
		
			// now get a new session and start transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println(" \n Getting student with id:" +studentId);
			
			Student myStudent= session.get(Student.class, studentId);
			
			myStudent.setLastName("Patel");
			System.out.println("Get complete: " +myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			// factory and session initialisation
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			session.createQuery("update Student set email='abcd@yahoo.com'")
			       .executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}

