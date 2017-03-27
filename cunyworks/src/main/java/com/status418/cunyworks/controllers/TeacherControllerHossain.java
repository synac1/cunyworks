package com.status418.cunyworks.controllers;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.TeacherBean;
import com.status418.cunyworks.data.FacadeImpl;

@Controller
@RequestMapping(value = "teacher0")
public class TeacherControllerHossain {
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home() {
		return "Hossain.html";
	}
	@RequestMapping(value = "getmodal", method = RequestMethod.GET)
	public String getModal() {
		return "hossainmodal.html";
	}

	@RequestMapping(value = "allCourses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<CourseBean>> getAllCourses() {

		TeacherBean teacher = new FacadeImpl().getByTeacherId(1);
	System.out.println(teacher);
		Set<CourseBean> allCourses = teacher.getCourses();

		return new ResponseEntity<Set<CourseBean>>(allCourses, HttpStatus.OK);
		
	}
	@RequestMapping(value="update",method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> update(@RequestBody TeacherBean teacher, @RequestBody CourseBean course){
		
		Set<CourseBean> courses = teacher.getCourses();
		courses.add(course);
		teacher.setCourses(courses);
		FacadeImpl facade = new FacadeImpl();
				facade.saveOrUpdate(teacher);
		
		
		return new  ResponseEntity<String>("Success!",HttpStatus.OK);
		
		
	}

}
