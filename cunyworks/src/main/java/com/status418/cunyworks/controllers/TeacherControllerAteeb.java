package com.status418.cunyworks.controllers;

import static com.status418.cunyworks.utils.Constants.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "teacher")
public class TeacherControllerAteeb {

	@RequestMapping(value = TEACHER_HOME_URL, method = RequestMethod.GET)
	public String home() {
		return TEACHER_HOME_PAGE;
	}

	
	@RequestMapping(value=TEACHER_ADD_URL, method=RequestMethod.POST)
	public ResponseEntity<String> addNewCourse(@RequestParam(value="", required = true) String make){
		
		
		return null;
	}
	
	
	
	
}
