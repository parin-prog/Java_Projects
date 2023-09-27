package com.parprog.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parprog.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomer() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by last_name", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

    @Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the session ...Finally
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void delete(int theId) {
		
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
