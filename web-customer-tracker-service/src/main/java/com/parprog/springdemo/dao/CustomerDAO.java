package com.parprog.springdemo.dao;

import java.util.List;

import com.parprog.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void delete(int theId);
	 
	
}
