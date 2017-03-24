package com.status418.cunyworks.controllers;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.dao.StudentDAOImpl;

@Controller
@RequestMapping(value = "student")
public class StudentControllerYanilda {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String HomePage1(){
		return"Yani.html";
		
	}
	
	

	@RequestMapping(value = "new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // write directly to response body.. no redirection
	public ResponseEntity<String> enrollclass(@RequestBody StudentBean student, @RequestBody CourseBean course) {
		int courseId=course.getCourseId();
		Set<CourseBean> courses= student.getCourses();
		courses.add(course);
		student.setCourses(courses);
		
		ApplicationContext contxt = new ClassPathXmlApplicationContext("/WEB_INF/beanbag.xml");
		contxt.getBean(StudentDAOImpl.class).saveOrUpdate(student);
	
		return new ResponseEntity<String>("Success!", HttpStatus.CREATED);
	}

	

	@RequestMapping(value = "a_drop", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // write directly to response body.. no redirection
	public ResponseEntity<String> anotherdrop(@RequestBody StudentBean student, @RequestBody CourseBean course) {
		int courseId=course.getCourseId();
		Set<CourseBean> courses= student.getCourses();
		courses.remove(course);
		student.setCourses(courses);
		
		ApplicationContext contxt = new ClassPathXmlApplicationContext("/WEB_INF/beanbag.xml");
		contxt.getBean(StudentDAOImpl.class).saveOrUpdate(student);;
	
		return new ResponseEntity<String>("Success!", HttpStatus.CREATED);
	}
	
	
	
	
	
	
}
