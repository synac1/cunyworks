package com.status418.cunyworks.controllers;

import java.util.Iterator;
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
import com.status418.cunyworks.beans.TeacherBean;
import com.status418.cunyworks.data.FacadeImpl;
import com.status418.cunyworks.services.UserService;

@Controller
@RequestMapping(value = "teacher")
public class TeacherController {

	@Autowired
	private FacadeImpl facadeImpl;
	@Autowired
	private UserService userService;

	@RequestMapping(value = {"/", ""}, method = {RequestMethod.GET, RequestMethod.POST})
	public String home() {
		return "teacher.html";
	}

	@RequestMapping(value = "allCourses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<CourseBean>> getAllCourses() {
		TeacherBean teacher = userService.getCurrentTeacher();
		Set<CourseBean> allCourses = teacher.getCourses();
		return new ResponseEntity<Set<CourseBean>>(allCourses, HttpStatus.OK);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> update(@RequestBody CourseBean course) {
		TeacherBean teacher = userService.getCurrentTeacher();

		CourseBean cbean = facadeImpl.getCourseById(course.getCourseId());
		Set<CourseBean> courses = teacher.getCourses();
		Iterator<CourseBean> it = courses.iterator();
		while(it.hasNext()){
			CourseBean cB = it.next();
			if(cB.getCourseId() == cbean.getCourseId()){
				it.remove();
			}
		}

		cbean.setName(course.getName());
		cbean.setRoom(course.getRoom());
		cbean.setTeacher(teacher);
		cbean.copyEndDate(course.getEndDate());
		cbean.copyStartDate(course.getStartDate());
		cbean.setDescription(course.getDescription());
		cbean.setEnrollmentCapacity(course.getEnrollmentCapacity());
		facadeImpl.merge(cbean);
		
		courses.add(cbean);
		teacher.setCourses(courses);
		facadeImpl.merge(teacher);
		return new ResponseEntity<String>("Success!", HttpStatus.OK);
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addNewCourse(@RequestBody CourseBean course) {
		System.out.println(course);
		
		TeacherBean teacher = userService.getCurrentTeacher();
		course.getSubject().addCourse(course);
		facadeImpl.saveOrUpdate(course);
		
		course.setTeacher(teacher);
		teacher.addCourse(course);
		facadeImpl.merge(teacher);
		return new ResponseEntity<String>("Success!", HttpStatus.OK);
	}

	@RequestMapping(value = "subjects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<SubjectBean>> getAllSubjects() {
		Set<SubjectBean> subjects = facadeImpl.getAllSubjects();
		return new ResponseEntity<Set<SubjectBean>>(subjects, HttpStatus.OK);
	}

}
