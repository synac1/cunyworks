package com.status418.cunyworks.controllers;

import static com.status418.cunyworks.utils.Constants.TEACHER_COURSE_INSERT_URL;
import static com.status418.cunyworks.utils.Constants.TEACHER_HOME_PAGE;
import static com.status418.cunyworks.utils.Constants.TEACHER_HOME_URL;
import static com.status418.cunyworks.utils.Constants.TEACHER_SUBJECTS_URL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.data.FacadeImpl;

@Controller
@RequestMapping(value = "teacher")
public class TeacherControllerAteeb {

	@RequestMapping(value = TEACHER_HOME_URL, method = RequestMethod.GET)
	public String home() {
		return TEACHER_HOME_PAGE;
	}

	@RequestMapping(value = TEACHER_COURSE_INSERT_URL, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> addNewCourse(@RequestBody CourseBean course) {

		System.out.println(Arrays.asList(course));
		return new ResponseEntity<String>("Success!", HttpStatus.CREATED);
	}

	@RequestMapping(value = TEACHER_SUBJECTS_URL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	// public ResponseEntity<List<String>> getAllSubjects() {
	public ResponseEntity<Set<SubjectBean>> getAllSubjects() {
		Set<SubjectBean> subjects = new FacadeImpl().getAllSubjects();
		/*List<String> subjectNames = new ArrayList<String>();
		for (SubjectBean s : subjects) {
			subjectNames.add(s.getName());
		}

		Collections.sort(subjectNames);*/

		// return new ResponseEntity<List<String>>(subjectNames, HttpStatus.OK);
		return new ResponseEntity<Set<SubjectBean>>(subjects, HttpStatus.OK);
	}
}
