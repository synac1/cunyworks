package com.status418.cunyworks.dao.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.dao.StudentDAOImpl;
import com.status418.cunyworks.hibernate.HibernateUtil;

public class StudentDAOImplTest {/*

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
	public void testGetStudentById() {
		StudentBean s = new StudentDAOImpl(session).getStudentById(1);
		System.out.println(s.getFirstName());
	}

	@Test
	public void testGetStudentByUsername() {
		StudentBean s = new StudentDAOImpl(session).getStudentByUsername("a@email.com");
		System.out.println(s.getFirstName());
	}

	@Test
	public void testGetAllStudents() {
		System.out.println(new StudentDAOImpl(session).getAllStudents().size());
	}

	@Test
	public void testUpdateStudent() {
		Transaction tx = session.beginTransaction();

		StudentBean s1 = new StudentBean();
		s1.setAddress("abdefc");
		s1.setBirthday(new Date());
		s1.setEmail("b@email.com");
		s1.setFirstName("Alpha");
		s1.setLastName("Omega");
		s1.setPhone(1234567989);
		s1.setPassword("temp");

		new StudentDAOImpl(session).updateStudent(s1);

		tx.commit();
	}
*/
}
