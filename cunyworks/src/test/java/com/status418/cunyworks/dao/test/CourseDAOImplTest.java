package com.status418.cunyworks.dao.test;

import java.util.Date;
import java.util.Set;

import org.junit.Test;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.dao.CourseDAOImpl;

public class CourseDAOImplTest {
	
	@Test
	public void testGeAllCourses() {
		CourseDAOImpl dao = new CourseDAOImpl();
		Set<CourseBean> allCourses = dao.geAll();
		System.out.println(allCourses);
	}

	@Test
	public void testGetAllStudentsByCourse() {
		CourseBean course = new CourseBean();
		CourseDAOImpl dao = new CourseDAOImpl();
		Set<StudentBean> allStudents = dao.getAllStudentsByCourse(course);
		System.out.println(allStudents);
	}

	@Test
	public void testSaveOrUpdate() {
		CourseBean course = new CourseBean();
		// course.setCourseId(999);
		course.setStartDate(new Date());
		course.setEndDate(new Date());
		course.setEnrollmentCapacity(5);
		course.setName("Computer Science 101");
		course.setRoom("123");
		new CourseDAOImpl().saveOrUpdate(course);
	}

	@Test
	public void testDeleteCourse() {
		new CourseDAOImpl().delete(new CourseBean());
	}

}
