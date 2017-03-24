package com.status418.cunyworks.dao.test;

import java.util.Date;

import org.junit.Test;

import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.dao.StudentDAOImpl;

public class StudentDAOImplTest {

	@Test
	public void testGetStudentById() {
		StudentBean s = new StudentDAOImpl().getById(1);
		System.out.println(s.getFirstName());
	}

	@Test
	public void testGetStudentByUsername() {
		StudentBean s = new StudentDAOImpl().getByUsername("a@email.com");
		System.out.println(s.getFirstName());
	}

	@Test
	public void testGetAllStudents() {
		System.out.println(new StudentDAOImpl().getAll().size());
	}

	@Test
	public void testUpdateStudent() {
		StudentBean s1 = new StudentBean();
		s1.setAddress("abdefc");
		s1.setBirthday(new Date());
		s1.setEmail("a@email.com");
		s1.setFirstName("Alpha");
		s1.setLastName("Omega");
		s1.setPhone("1234567989");
		s1.setPassword("temp");
		new StudentDAOImpl().saveOrUpdate(s1);
	}
}
