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
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage() {
		return "home.html";
	}

	
}
