package com.parprog.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parprog.springdemo.dao.CustomerDAO;
import com.parprog.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// Inject Customer DAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomer();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		 customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
		
	}

	@Override
	@Transactional
	public void delete(int theId) {
		customerDAO.delete(theId);
		
	}
	
}
