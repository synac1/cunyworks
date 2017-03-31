package com.status418.cunyworks.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.dao.StudentDAOImpl;
import com.status418.cunyworks.data.FacadeImpl;

@Controller
@RequestMapping(value = "student")
public class StudentControllerYanilda {

	@Autowired
	private FacadeImpl facadeImpl;

	public void setFacadeImpl(FacadeImpl facadeImpl) {
		this.facadeImpl = facadeImpl;
	}

	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public String HomePage1() {
		return "Yani.html";

	}

	@RequestMapping(value = "new_courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<CourseBean>> getallCourses() {
		Set<CourseBean> courses = facadeImpl.getAllCourses();
		System.out.println(courses);
		return new ResponseEntity<Set<CourseBean>>(courses, HttpStatus.OK);
	}

	@RequestMapping(value = "new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // write directly to response body.. no redirection
	public ResponseEntity<String> enrollclass(@RequestBody String str) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		try {
			node = mapper.readTree(str);
			int studentId = mapper.convertValue(node.get("studentN"), int.class);
			int courseId = mapper.convertValue(node.get("courseN"), int.class);
			System.out.println(studentId + "," + courseId);

			StudentBean student = facadeImpl.getStudentById(studentId);
			CourseBean course = facadeImpl.getCourseById(courseId);

			student.getCourses().add(course);
			course.getStudents().add(student);

			facadeImpl.merge(course);

			System.out.println(student.getCourses().size());
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<String>("Success!", HttpStatus.CREATED);
	}

	@RequestMapping(value = "drop_course", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // write directly to response body.. no redirection
	public ResponseEntity<String> anotherdrop(@RequestBody String str) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		try {
			node = mapper.readTree(str);
			int studentId = mapper.convertValue(node.get("studentN"), int.class);
			int courseId = mapper.convertValue(node.get("courseN"), int.class);
			System.out.println(studentId + "," + courseId);

			StudentBean student = facadeImpl.getStudentById(studentId);
			CourseBean course = facadeImpl.getCourseById(courseId);

			student.getCourses().remove(course);
			course.getStudents().remove(student);

			facadeImpl.merge(course);

			System.out.println(student.getCourses().size());
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<String>("Success!", HttpStatus.OK);
	}

}
