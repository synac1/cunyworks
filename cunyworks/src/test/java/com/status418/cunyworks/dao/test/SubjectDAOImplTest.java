package com.status418.cunyworks.dao.test;

import org.junit.Test;

import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.dao.SubjectDAOImpl;

public class SubjectDAOImplTest {

	@Test
	public void testGetAllSubjects() {
		SubjectDAOImpl sb = new SubjectDAOImpl();
		System.out.println(sb.getAllSubjects().size());
	}

	@Test
	public void testGetAllTextBooksBySubject() {
		SubjectBean sb = new SubjectBean();
		sb.setSubjectId(1);
		sb.setName("ENGLISH");
		System.out.println(new SubjectDAOImpl().getAllTextBooksBySubject("MATH"));
	}

	@Test
	public void testSaveOrUpdate() {
		new SubjectDAOImpl().saveOrUpdate(new SubjectBean());
	}

	@Test
	public void testGetAllCoursesBySubject() {
		SubjectBean sb = new SubjectBean();
		sb.setSubjectId(1);
		sb.setName("english");
		System.out.println(new SubjectDAOImpl().getAllCoursesBySubject("english"));
	}


}
