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
		theModel.addAttribute("customer", new Customer());
		return "customer-form";

	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

		if(theBindingResult.hasErrors()){
			return "customer-form";           //Take them back to the form to try again

		}

		return "customer-confirmation";

	}

}
