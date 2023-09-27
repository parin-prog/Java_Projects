package com.parprog.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.parprog.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
	
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId=7;
			// MY NEW CODE
		
			// now get a new session and start transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println(" \n Getting student with id:" +studentId);
			
			Student myStudent= session.get(Student.class, studentId);
			
			//System.out.println("Delete Student :"+myStudent);
			//session.delete(myStudent);
			
			System.out.println("Delete Student 5 :"+myStudent);
			session.createQuery("delete from Student where id=5").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}

