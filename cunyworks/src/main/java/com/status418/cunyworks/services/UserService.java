package com.status418.cunyworks.services;

import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.TeacherBean;

public class UserService {

	private TeacherBean currentTeacher = null;
	private StudentBean currentStudent = null;

	public UserService() {
		super();
	}

	public TeacherBean getCurrentTeacher() {
		return currentTeacher;
	}

	public void setCurrentTeacher(TeacherBean currentTeacher) {
		this.currentTeacher = currentTeacher;
	}

	public StudentBean getCurrentStudent() {
		return currentStudent;
	}

	public void setCurrentStudent(StudentBean currentStudent) {
		this.currentStudent = currentStudent;
	}

	public void reset(){
		this.currentStudent = null;
		this.currentTeacher = null;
	}
	
}
