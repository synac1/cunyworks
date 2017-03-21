package com.status418.cunyworks.dao.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.status418.cunyworks.beans.TeacherBean;
import com.status418.cunyworks.dao.TeacherDAOImpl;
import com.status418.cunyworks.hibernate.HibernateUtil;

public class TeacherDAOImplTest {

	private static Session session;

	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void testGetTeacherById() {
		TeacherBean t = new TeacherDAOImpl(session).getTeacherById(1);
		System.out.println(t);
	}

	@Test
	public void testGetTeacherByUsername() {
		TeacherBean t = new TeacherDAOImpl(session).getTeacherByUsername("teacher@school.com");
		System.out.println(t);
	}

	@Test
	public void testInsertTeacher() {
		Transaction tx = session.beginTransaction();

		TeacherBean t = new TeacherBean();
		t.setAddress("someplace 3ds");
		t.setBirthday(new Date());
		t.setEmail("teacher@college.com");
		t.setFirstName("Teacher Romeo");
		t.setLastName("Teacher Juliet");
		t.setPhone(123456789);
		t.setTitle("Profe-ssory");
		t.setPassword("temp3");

		new TeacherDAOImpl(session).saveOrUpdateTeacher(t);

		tx.commit();

	}

}
