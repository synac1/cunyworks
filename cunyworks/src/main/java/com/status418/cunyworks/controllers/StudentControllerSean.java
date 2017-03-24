package com.status418.cunyworks.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class StudentControllerSean {
	
	 
	
	@RequestMapping(value="student", method=RequestMethod.GET)
	public String HomePage(){
		return"Sean.html";
		
	}
	
	public ResponseEntity<List<CourseBean>> getall(){
		
	ApplicationContext contxt= ClassPathXmlApplicationContext("beanbag.xml");
	//contxt.getBean(CourseDAOImpl);
		return new ResponseEntity<List<CourseBean>>(courses, HttpStatus.OK);
	}
	
	@RequestMapping(value="enroll", method=RequestMethod.POST)
	public void EnrollPage(){
		
	}
	
	@RequestMapping(value="drop", method=RequestMethod.POST)
	public void dropCoursePage(){
		
	}

	

}
