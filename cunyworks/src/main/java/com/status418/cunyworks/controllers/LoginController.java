package com.status418.cunyworks.controllers;

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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(String username, String password) {
		StudentBean s = facadeImpl.getStudentByUsername(username);
		TeacherBean t = facadeImpl.getTeacherByUsername(username);

		if (s != null && s.getPassword().equals(password)) {

			return "student";
		} else if (t != null && t.getPassword().equals(password)) {
			return "teacher";

		} else {
			return "login";
		}
	}

}
