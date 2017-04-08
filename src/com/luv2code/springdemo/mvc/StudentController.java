package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		
		Student theStudent = new Student();
		
		//add Student object to the model
		theModel.addAttribute("student", theStudent);
				
		return "student-form";
		
	}
	
	@RequestMapping("/processForm")
	public String showForm(@ModelAttribute("student") Student theStudent){
		
		//log the output data
		System.out.println(theStudent.getFirstName() + " " + theStudent.getLastName());
				
		return "student-confirmation";
		
	}
	
	
	
}
