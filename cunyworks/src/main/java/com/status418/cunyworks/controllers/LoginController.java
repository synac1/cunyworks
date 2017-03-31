package com.status418.cunyworks.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.TeacherBean;
import com.status418.cunyworks.data.FacadeImpl;
import com.status418.cunyworks.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private FacadeImpl facadeImpl;
	@Autowired
	private UserService userService;

	public void setFacadeImpl(FacadeImpl facadeImpl) {
		this.facadeImpl = facadeImpl;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		return "login.html";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String submit(String username, String password, HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException {

		StudentBean student = facadeImpl.getStudentByUsername(username);
		if (student != null && student.getPassword().equals(password)) {
			System.out.println("User is a Student!");
			userService.setCurrentStudent(student);
			return "redirect:/student";
		}

		TeacherBean teacher = facadeImpl.getTeacherByUsername(username);
		if (teacher != null && teacher.getPassword().equals(password)) {
			System.out.println("User is a Teacher!");
			userService.setCurrentTeacher(teacher);
			return "redirect:/teacher";
		}

		System.out.println("Invalid User!");
		return "login";

	}



}
