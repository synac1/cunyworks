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

@Controller
public class LoginController {

	@Autowired
	private FacadeImpl facadeImpl;

	public void setFacadeImpl(FacadeImpl facadeImpl) {
		this.facadeImpl = facadeImpl;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		return "login.html";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String submit(String username, String password, HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException {
		System.out.println("User: " + username + ", Pass: " + password);
		StudentBean s = facadeImpl.getStudentByUsername(username);
		TeacherBean t = facadeImpl.getTeacherByUsername(username);

		if (s != null && s.getPassword().equals(password)) {
			System.out.println("User is a Student!");
			return "redirect:/student";
		} else if (t != null && t.getPassword().equals(password)) {
			System.out.println("User is a Teacher!");
			return "redirect:/teacher";
		} else {
			System.out.println("Invalid User!");
			return "login";
		}
	}

}
