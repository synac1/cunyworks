package com.status418.cunyworks.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.dao.StudentDAOImpl;

public class StudentDAOImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStudentById() {
	StudentBean s=new StudentDAOImpl().getStudentById(1);
	System.out.println(s.getFirstName());
	}

	@Test
	public void testGetStudentByUsername() {
		
		StudentBean s=new StudentDAOImpl().getStudentByUsername("a@email.com");
		System.out.println(s.getFirstName());
	}

	@Test
	public void testGetAllStudents() {
		System.out.println(3);
	}

	@Test
	public void testUpdateStudent() {
		System.out.println(4);
	}

}
