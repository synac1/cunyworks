package com.status418.cunyworks.controllers;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.dao.StudentDAOImpl;

public class StudentControllerSean {

	@RequestMapping(value = "student", method = RequestMethod.GET)
	public String HomePage() {
		return "Sean.html";

	}

	@RequestMapping(value = "courses", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<CourseBean>> getall() {

		ApplicationContext contxt = new ClassPathXmlApplicationContext("/WEB_INF/beanbag.xml");
		Set<CourseBean> courses = contxt.getBean(StudentDAOImpl.class).getById(1).getCourses();
		return new ResponseEntity<Set<CourseBean>>(courses, HttpStatus.OK);
	}

	@RequestMapping(value = "enroll", method = RequestMethod.POST)
	public void EnrollPage() {

	}

	@RequestMapping(value = "drop", method = RequestMethod.POST)
	public void dropCoursePage() {

	}

}
