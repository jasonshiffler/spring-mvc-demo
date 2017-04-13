package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {

	
	//This method is a preprocessor that clears out white space in a string
	//to prevent whitespace from passing a validation test
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		//Create the string trimmer
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		//add the trimmer to the dataBinder
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
		
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer()); //create a customer object and add to the model
		return "customer-form";

	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

		//Prints errors to console when form is submitted
		System.out.println("Binding result: " + theBindingResult);
		
		System.out.println("\n\n\n");
		
		if(theBindingResult.hasErrors()){
			return "customer-form";           //Take them back to the form to try again

		}

		//if it was successful print out the confirmation form 
		return "customer-confirmation";

	}

}
