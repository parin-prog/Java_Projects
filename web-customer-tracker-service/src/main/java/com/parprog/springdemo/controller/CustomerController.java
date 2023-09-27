package com.parprog.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parprog.springdemo.dao.CustomerDAO;
import com.parprog.springdemo.entity.Customer;
import com.parprog.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject customerService
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get the customers from the dao
		 List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		 
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save customer using our service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		
		// get the customer from database
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set customer as a model attribute to pre-populate form
		theModel.addAttribute("customer",theCustomer);
		
		// send to our form
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String delete(@RequestParam("customerId") int theId,Model theModel) {
		
		// delete customer from database through service
		customerService.delete(theId);
		
		return "redirect:/customer/list";
	}
}
