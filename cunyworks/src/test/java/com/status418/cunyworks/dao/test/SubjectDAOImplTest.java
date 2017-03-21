package com.status418.cunyworks.dao.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TextBookBean;
import com.status418.cunyworks.dao.SubjectDAOImpl;
import com.status418.cunyworks.hibernate.HibernateUtil;

public class SubjectDAOImplTest {
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	private Session session;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllSubjects() {
		
		SubjectDAOImpl sb = new SubjectDAOImpl();
		
	System.out.println(sb.getAllSubjects().size());
	}

	@Test
	public void testGetAllTextBooksBySubject() {
		
		SubjectBean	sb = new SubjectBean();
		sb.setSubjectId(1);
		sb.setSubjectName("english");
		
		System.out.println(new SubjectDAOImpl().getAllTextBooksBySubject("MATH"));
	}

	@Test
	public void testSaveOrUpdate() {
		new SubjectDAOImpl().saveOrUpdate(new SubjectBean());
	}


	public void testGetAllCoursesBySubject() {
		SubjectBean	sb = new SubjectBean();
		sb.setSubjectId(1);
		sb.setSubjectName("english");
		System.out.println(new SubjectDAOImpl().getAllCoursesBySubject("english"));
	}
	
	public void testTextBookInsert(){
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		TextBookBean book = new TextBookBean();
		book.setISBN(14);
		book.setTextBookId(3);
		book.setTextBookName("INTRO TO MATH");
		
		session.save(book);
		

		tx.commit();
		
		
		
	}
	
	
	
	
	
	
	public void testSubjectInsert(){
		session =sf.openSession();
		Transaction tx = session.beginTransaction();

		SubjectBean sub = new SubjectBean();
		
		sub.setSubjectId(3);
		sub.setSubjectName("LATIN");
		//sub.setCourses(null);
		//sub.setTextBooks(null);
		new SubjectDAOImpl().saveOrUpdate(sub);

		tx.commit();
		
		
	}

}
