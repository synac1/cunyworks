package com.status418.cunyworks.controllers;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.TeacherBean;

@Controller
@RequestMapping(value = "teacher")
public class TeacherControllerHossain {
	@RequestMapping(value = "allCourses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<CourseBean>> getAllCourses(TeacherBean teacher) {
	
		Set<CourseBean> allCourses = teacher.getCourses();

		return new ResponseEntity<Set<CourseBean>>(allCourses, HttpStatus.OK);

	}
	
//public ResponseEntity<CourseBean> modify(CourseBean ){
//	
//	
//}
	
	
	

}
