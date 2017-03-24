package com.status418.cunyworks.dao.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TextbookBean;
import com.status418.cunyworks.dao.SubjectDAOImpl;
import com.status418.cunyworks.hibernate.HibernateUtil;

public class SubjectDAOImplTest {

	private Session session;

	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void testGetAllSubjects() {
		SubjectDAOImpl sb = new SubjectDAOImpl(session);
		System.out.println(sb.getAllSubjects().size());
	}

	@Test
	public void testGetAllTextBooksBySubject() {
		SubjectBean sb = new SubjectBean();
		sb.setSubjectId(1);
		sb.setName("ENGLISH");
		System.out.println(new SubjectDAOImpl(session).getAllTextBooksBySubject("MATH"));
	}

	@Test
	public void testSaveOrUpdate() {
		new SubjectDAOImpl(session).saveOrUpdate(new SubjectBean());
	}

	public void testGetAllCoursesBySubject() {
		SubjectBean sb = new SubjectBean();
		sb.setSubjectId(1);
		sb.setName("english");
		System.out.println(new SubjectDAOImpl(session).getAllCoursesBySubject("english"));
	}
 	public void testTextBookInsert() {
		Transaction tx = session.beginTransaction();
		TextbookBean book = new TextbookBean();
		book.setISBN("14");
		book.setTextbookId(3);
		book.setName("INTRO TO MATH");
		session.save(book);
		tx.commit();
	}
	
	public void testSubjectInsert() {
		Transaction tx = session.beginTransaction();
		SubjectBean sub = new SubjectBean();
		sub.setSubjectId(3);
		sub.setName("LATIN");
		new SubjectDAOImpl(session).saveOrUpdate(sub);
		tx.commit();
	}

}
