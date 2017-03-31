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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.data.FacadeImpl;
import com.status418.cunyworks.services.UserService;

@Controller
// @RequestMapping(value ="/student")
public class StudentController {

	@Autowired
	private FacadeImpl facadeImpl;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String HomePage() {
		return "student.html";

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

	@RequestMapping(value = "courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Set<CourseBean>> getCourses() {
		Set<CourseBean> courses = userService.getCurrentStudent().getCourses();
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

			StudentBean student = userService.getCurrentStudent();
			CourseBean course = facadeImpl.getCourseById(courseId);
			
			Set<StudentBean> s=course.getStudents();
			Set<CourseBean> c=student.getCourses();
			
			Iterator<StudentBean> it =s.iterator();
			Iterator<CourseBean> itc =c.iterator();
			
			while(it.hasNext()){
				StudentBean sb =it.next();
				System.out.println(sb);
				if(sb.getStudentId()==student.getStudentId()){
					it.remove();
					break;
				}
			}
			course.setStudents(s);
		
			while(itc.hasNext()){
				CourseBean cb =itc.next();
				System.out.println(cb);
				if(cb.getCourseId()==courseId){
					itc.remove();
					break;
				}
			}
			
			student.setCourses(c);

			
			facadeImpl.merge(course);

			System.out.println(student.getCourses().size());
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<String>("Success!", HttpStatus.OK);
	}

}
