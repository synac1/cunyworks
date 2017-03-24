package com.status418.cunyworks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.status418.cunyworks.utils.Constants.*;

@Controller
@RequestMapping(value = "teacher")
public class TeacherControllerAteeb {

	@RequestMapping(value = TEACHER_HOME_URL, method = RequestMethod.GET)
	public String home() {
		return TEACHER_HOME_PAGE;
	}

}
