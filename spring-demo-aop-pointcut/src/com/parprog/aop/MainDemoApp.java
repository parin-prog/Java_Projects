package com.parprog.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.parprog.aopdemo.dao.Account;
import com.parprog.aopdemo.dao.AccountDAO;
import com.parprog.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO",MembershipDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount,true);
		
		// call the the membership business method
		theMembershipDAO.addMember();
		
		// close the context
        context.close();
        
 
		
	}

}
