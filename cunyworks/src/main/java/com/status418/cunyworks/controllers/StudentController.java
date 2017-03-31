package com.status418.cunyworks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.status418.cunyworks.data.FacadeImpl;

@Controller
@RequestMapping(value = "student")
public class StudentController {

	@Autowired
	private FacadeImpl facadeImpl;

	public void setFacadeImpl(FacadeImpl facadeImpl) {
		this.facadeImpl = facadeImpl;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String HomePage(){
		return"index.html";
		
	}
	
	@RequestMapping(value="/enroll", method=RequestMethod.POST)
	public void EnrollPage(){
		//TODO: YANILDAS
	}
	
	@RequestMapping(value="/drop", method=RequestMethod.POST)
	public void dropCoursePage(){
		
	}

	
	
	
	
	
	
}
