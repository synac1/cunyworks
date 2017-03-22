package com.status418.cunyworks.dao;

import java.util.Set;

import com.status418.cunyworks.beans.StudentBean;

public interface StudentDAO {

	public StudentBean getStudentById(int id);

	public StudentBean getStudentByUsername(String username);

	public Set<StudentBean> getAllStudents();

	public void updateStudent(StudentBean student); // Check if this works for removing course

}
