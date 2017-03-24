package com.status418.cunyworks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "student")
public class StudentController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String HomePage(){
		return"index.html";
		//TODO: Seans
		
	}
	
	@RequestMapping(value="/enroll", method=RequestMethod.POST)
	public void EnrollPage(){
		//TODO: YANILDAS
	}
	
	@RequestMapping(value="/drop", method=RequestMethod.POST)
	public void dropCoursePage(){
		
	}

	
	
	
	
	
	
}
