package com.status418.cunyworks.dao.test;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.status418.cunyworks.hibernate.HibernateUtil;

public class CourseDAOTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Before Every Test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After Every Test");
	}

	@Test
	public void test() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
	}

}
