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
import com.status418.cunyworks.data.FacadeImpl;

@Controller 
@RequestMapping(value="student1")
public class StudentControllerSean {

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String HomePage() {
		return "Sean.html";

	}

	@RequestMapping(value = "courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<CourseBean>> getall() {
		/**
		 * currently getbyID has value of 1 hard coded in for test purposes, fix later
		 */

		/*ApplicationContext contxt = new ClassPathXmlApplicationContext("/WEB_INF/beanbag.xml");
		Set<CourseBean> courses = contxt.getBean(StudentDAOImpl.class).getById(1).getCourses();
		return new ResponseEntity<Set<CourseBean>>(courses, HttpStatus.OK);*/
		
		Set<CourseBean> courses= new FacadeImpl().getById(1).getCourses();
		System.out.println(courses);
		return new ResponseEntity<Set<CourseBean>>(courses, HttpStatus.OK);
		
	}

	@RequestMapping(value = "enroll", method = RequestMethod.POST)
	public void EnrollPage() {

	}

	@RequestMapping(value = "drop", method = RequestMethod.POST)
	public void dropCoursePage() {

	}

}
