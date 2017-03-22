package com.status418.cunyworks.dao.test;

import java.util.Date;
import java.util.Set;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.dao.CourseDAOImpl;
import com.status418.cunyworks.hibernate.HibernateUtil;

public class CourseDAOImplTest {
	private Session session;
	CourseBean course = new CourseBean();

	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void testGeAllCourses() {
		CourseDAOImpl dao = new CourseDAOImpl(session);
		Set<CourseBean> allCourses = dao.geAllCourses();
		System.out.println(allCourses);
		if (allCourses == null) {
			// fail("Didn't work");
		}
	}

	@Test
	public void testGetAllStudentsByCourse() {
		CourseBean course = new CourseBean();
		CourseDAOImpl dao = new CourseDAOImpl(session);
		Set<StudentBean> allStudents = dao.getAllStudentsByCourse(course);
		if (allStudents == null) {
			// fail("didn't work");
		}
	}

	@Test
	public void testSaveOrUpdate() {
		/*
		 * required values for database are courseid startdate enddate enrollment capcity name scheduletime
		 * 
		 */
		CourseBean course = new CourseBean();
		// course.setCourseId(999);
		course.setStartDate(new Date());
		course.setEndDate(new Date());
		course.setEnrollmentCapacity(5);
		course.setName("Computer Science 101");
		course.setRoom("123");
		Transaction tx = session.beginTransaction();
		CourseDAOImpl dao = new CourseDAOImpl(session);
		dao.saveOrUpdate(course);
		// System.out.println("ENDOF TEST");
		tx.commit();
	}

	@Test
	public void testDeleteCourse() {
		CourseDAOImpl dao = new CourseDAOImpl(session);
		dao.deleteCourse(course);
		// fail("Not yet implemented");
	}

}
