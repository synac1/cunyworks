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
import com.status418.cunyworks.beans.TeacherBean;
import com.status418.cunyworks.data.FacadeImpl;

@Controller
@RequestMapping(value = "teacher")
public class TeacherController {

	@Autowired
	private FacadeImpl facadeImpl;

	public void setFacadeImpl(FacadeImpl facadeImpl) {
		this.facadeImpl = facadeImpl;
	}
	@RequestMapping(value = {"/", ""}, method = {RequestMethod.GET, RequestMethod.POST})
	public String home() {
		return "teacher.html";
	}

	@RequestMapping(value = "allCourses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<CourseBean>> getAllCourses() {

		TeacherBean teacher = facadeImpl.getTeacherById(1);
		System.out.println(teacher);
		Set<CourseBean> allCourses = teacher.getCourses();
		// System.out.println(allCourses.iterator().next().getSubject().getName());
		return new ResponseEntity<Set<CourseBean>>(allCourses, HttpStatus.OK);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> update(@RequestBody CourseBean course) {
		TeacherBean teacher = facadeImpl.getTeacherById(1);

		CourseBean cbean = facadeImpl.getCourseById(course.getCourseId());
		cbean.setName(course.getName());
		cbean.setRoom(course.getRoom());
		cbean.setTeacher(teacher);
		cbean.setStartDate(course.getStartDate().toString());

		cbean.copyEndDate(course.getEndDate());
		cbean.copyStartDate(course.getStartDate());
		cbean.setDescription(course.getDescription());
		cbean.setEnrollmentCapacity(course.getEnrollmentCapacity());
		// cbean.setStartDate(new
		// SimpleDateFormat("yyyy-MM-dd").format(course.getStartDate()));
		System.out.println(cbean);
		System.out.println(course.getSubject());

		facadeImpl.merge(cbean);
		Set<CourseBean> courses = teacher.getCourses();

		courses.add(cbean);
		teacher.setCourses(courses);
		facadeImpl.merge(teacher);

		return new ResponseEntity<String>("Success!", HttpStatus.OK);
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> addNewCourse(@RequestBody CourseBean course) {
		TeacherBean teacher = facadeImpl.getTeacherById(1);
		course.setTeacher(teacher);
		teacher.addCourse(course);
		course.getSubject().addCourse(course);
		facadeImpl.saveOrUpdate(course);
		facadeImpl.merge(teacher);
		return new ResponseEntity<String>("Success!", HttpStatus.CREATED);
	}

	@RequestMapping(value = "subjects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<SubjectBean>> getAllSubjects() {
		Set<SubjectBean> subjects = facadeImpl.getAllSubjects();
		return new ResponseEntity<Set<SubjectBean>>(subjects, HttpStatus.OK);
	}

}
