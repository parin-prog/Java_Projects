package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
	
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Parinn","Patel","parinvaghani001@gmail.com");
			Student tempStudent2= new Student("Justinn","Bieber","jbjalsa@gmail.com");
			Student tempStudent3= new Student("Charliey","Puth","charlieputh192@gmail.com");
			// start a transation
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3); 
			
			// commit transaction
			session.getTransaction().commit();
			
			// MY NEW CODE
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " +tempStudent.getId());
			
			// now get a new session and start transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println(" \n Getting student with id:" +tempStudent.getId());
			
			Student myStudent= session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " +myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}

