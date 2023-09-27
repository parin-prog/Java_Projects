package com.parprog.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo2 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employeeee.class)
				.buildSessionFactory();
				
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create Obj...");
			Employeeee employee= new Employeeee(1,"Parin","Patel");
			
			session.beginTransaction();
			
			session.save(employee);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!........");
			
		}
		finally {
			factory.close();
		}
				
	}
}
