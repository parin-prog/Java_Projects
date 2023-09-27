package com.parprog.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/main")
	public String showPage() {
		return "main-page";
	}
	
	// method for showing html page
	@RequestMapping("/showForm")
	public String showForm() {
		return "new-form";
	}
	
	// method for process html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "student-name";
	}
	
	// method for read the form data
	// add data to model
	@RequestMapping("/processFormv2")
	public String shoutName(HttpServletRequest request,Model model) {
		
		// read request parameter from html page
		String theName = request.getParameter("studentName");
		
		// convert data to uppercase
		theName = theName.toUpperCase();
		
		// create a message
		theName = "Hey there, " +theName;
		
		// add message to model
		model.addAttribute("message", theName);
		
		return "student-name";
	}
	
	@RequestMapping("/processFormv3")
	public String shoutName2(@RequestParam("studentName") String theName,Model model) {
		theName = theName.toUpperCase();
		theName = "Hey there, " +theName;
		model.addAttribute("message", theName);
		return "student-name";
	}
}
