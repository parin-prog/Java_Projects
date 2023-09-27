package com.parprog.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
	
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transation
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Patel'").list();
	
			// display the students
			System.out.println("\n \n\nStudents who have last name of Patel"); 
			displayStudents(theStudents);
			
			// students who have lastName Puth and firstName Justinn
			theStudents = session.createQuery("from Student s where s.lastName='Puth' OR s.firstName='Justinn'").list();
			System.out.println("\n \n\nStudents who have last name of Puth and Fname Justinn"); 
			displayStudents(theStudents);
			
			// students whose email id ends with gmail.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			System.out.println("\n \n\nStudents whose email ends with gmail.com"); 
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	

}

