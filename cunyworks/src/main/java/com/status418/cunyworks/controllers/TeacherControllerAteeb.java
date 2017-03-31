package com.status418.cunyworks.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.data.FacadeImpl;

@Controller
@RequestMapping(value = "teacher")
public class TeacherControllerAteeb {
	
	@Autowired
	private FacadeImpl facadeImpl;
	
	public void setFacadeImpl(FacadeImpl facadeImpl) {
		this.facadeImpl = facadeImpl;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Ateeb.html";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> addNewCourse(@RequestBody CourseBean course) {
		System.out.println(course);
		course.getSubject().addCourse(course);
		facadeImpl.saveOrUpdate(course);
		return new ResponseEntity<String>("Success!", HttpStatus.CREATED);
	}

	@RequestMapping(value = "subjects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<SubjectBean>> getAllSubjects() {
		Set<SubjectBean> subjects = facadeImpl.getAllSubjects();
		return new ResponseEntity<Set<SubjectBean>>(subjects, HttpStatus.OK);
	}
}
