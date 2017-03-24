package com.status418.cunyworks.dao.test;

import java.util.Date;

import org.junit.Test;

import com.status418.cunyworks.beans.TeacherBean;
import com.status418.cunyworks.dao.TeacherDAOImpl;

public class TeacherDAOImplTest {

	@Test
	public void testGetTeacherById() {
		TeacherBean t = new TeacherDAOImpl().getById(1);
		System.out.println(t);
	}

	@Test
	public void testGetTeacherByUsername() {
		TeacherBean t = new TeacherDAOImpl().getByUsername("teacher@school.com");
		System.out.println(t);
	}

	@Test
	public void testInsertTeacher() {
		TeacherBean t = new TeacherBean();
		t.setAddress("someplace 3ds");
		t.setBirthday(new Date());
		t.setEmail("teacher@college.com");
		t.setFirstName("Teacher Romeo");
		t.setLastName("Teacher Juliet");
		t.setPhone("123456789");
		t.setTitle("Profe-ssory");
		t.setPassword("temp3");
		new TeacherDAOImpl().saveOrUpdate(t);
	}

}
