package com.parprog.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	// return type changed
	public Boolean addMember() {
		
		System.out.println(getClass() +": Doing Stuff : Add an Membership Account");
		return true;
	}
}
