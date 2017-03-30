package com.status418.cunyworks.utils;

import java.util.Arrays;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TeacherBean;
import com.status418.cunyworks.beans.TextbookBean;
import com.status418.cunyworks.dao.CourseDAO;
import com.status418.cunyworks.dao.StudentDAO;
import com.status418.cunyworks.dao.SubjectDAO;
import com.status418.cunyworks.dao.TeacherDAO;

public class GenerateTestData {

	public static void main(String[] args) {

		String start = "2017-01-01";
		String end = "2017-06-31";
		String bDay = "1990-06-01";

		SubjectBean sub1 = new SubjectBean();
		sub1.setName("english");

		SubjectBean sub2 = new SubjectBean();
		sub2.setName("math");

		SubjectBean sub3 = new SubjectBean();
		sub3.setName("history");

		SubjectBean sub4 = new SubjectBean();
		sub4.setName("chemistry");

		SubjectBean sub5 = new SubjectBean();
		sub5.setName("biology");

		TextbookBean tb1 = new TextbookBean();
		tb1.setISBN("12345678910");
		tb1.setName("Book 1");

		TextbookBean tb2 = new TextbookBean();
		tb2.setISBN("1234448910");
		tb2.setName("Book 2");

		TextbookBean tb3 = new TextbookBean();
		tb3.setISBN("12335878910");
		tb3.setName("Book 3");

		TextbookBean tb4 = new TextbookBean();
		tb4.setISBN("97845345");
		tb4.setName("Book 4");

		TextbookBean tb5 = new TextbookBean();
		tb5.setISBN("1238453");
		tb5.setName("Book 5");

		StudentBean s1 = new StudentBean();
		s1.setFirstName("S1First");
		s1.setLastName("S1Last");
		s1.setBirthday(bDay);
		s1.setEmail("1@student.com");
		s1.setPassword("student");
		s1.setAddress("student 1 address");
		s1.setPhone("123456789");

		StudentBean s2 = new StudentBean();
		s2.setFirstName("S2First");
		s2.setLastName("S2Last");
		s2.setEmail("2@student.com");
		s2.setPassword("student");
		s2.setAddress("student 2 address");
		s2.setPhone("123444789");
		s2.setBirthday(bDay);

		StudentBean s3 = new StudentBean();
		s3.setFirstName("S3First");
		s3.setLastName("S3Last");
		s3.setEmail("3@student.com");
		s3.setPassword("student");
		s3.setAddress("student 3 address");
		s3.setPhone("323456789");
		s3.setBirthday(bDay);

		StudentBean s4 = new StudentBean();
		s4.setFirstName("S4First");
		s4.setLastName("S4Last");
		s4.setEmail("4@student.com");
		s4.setPassword("student");
		s4.setAddress("student 4 address");
		s4.setPhone("423456789");
		s4.setBirthday(bDay);

		StudentBean s5 = new StudentBean();
		s5.setFirstName("S5First");
		s5.setLastName("S5Last");
		s5.setEmail("5@student.com");
		s5.setPassword("student");
		s5.setAddress("student 5 address");
		s5.setPhone("523456789");
		s5.setBirthday(bDay);

		TeacherBean t1 = new TeacherBean();
		t1.setFirstName("t1First");
		t1.setLastName("t1Last");
		t1.setBirthday(bDay);
		t1.setEmail("1@teacher.com");
		t1.setPassword("teacher");
		t1.setAddress("teacher 1 address");
		t1.setPhone("123456789");
		t1.setTitle("Professor 1");

		TeacherBean t2 = new TeacherBean();
		t2.setFirstName("t2First");
		t2.setLastName("t2Last");
		t2.setBirthday(bDay);
		t2.setEmail("2@teacher.com");
		t2.setPassword("teacher");
		t2.setAddress("teacher 2 address");
		t2.setPhone("223456789");
		t2.setTitle("Professor 2");

		TeacherBean t3 = new TeacherBean();
		t3.setFirstName("t3First");
		t3.setLastName("t3Last");
		t3.setBirthday(bDay);
		t3.setEmail("3@teacher.com");
		t3.setPassword("teacher");
		t3.setAddress("teacher 3 address");
		t3.setPhone("323456789");
		t3.setTitle("Professor 3");

		TeacherBean t4 = new TeacherBean();
		t4.setFirstName("t4First");
		t4.setLastName("t4Last");
		t4.setBirthday(bDay);
		t4.setEmail("4@teacher.com");
		t4.setPassword("teacher");
		t4.setAddress("teacher 4 address");
		t4.setPhone("423456789");
		t4.setTitle("Professor 4");

		TeacherBean t5 = new TeacherBean();
		t5.setFirstName("t5First");
		t5.setLastName("t5Last");
		t5.setBirthday(bDay);
		t5.setEmail("5@teacher.com");
		t5.setPassword("teacher");
		t5.setAddress("teacher 5 address");
		t5.setPhone("523456789");
		t5.setTitle("Professor 5");

		CourseBean c1 = new CourseBean();
		c1.setCreated(new Date());
		c1.setName("Course 1");
		c1.setStartDate(start);
		c1.setEndDate(end);
		c1.setEnrollmentCapacity(25);
		c1.setRoom("A1");
		c1.setScheduleTime("Wed, 2:00PM - 4:00PM");
		c1.setDescription("This is Description 1");

		CourseBean c2 = new CourseBean();
		c2.setCreated(new Date());
		c2.setName("Course 2");
		c2.setStartDate(start);
		c2.setEndDate(end);
		c2.setEnrollmentCapacity(25);
		c2.setRoom("A2");
		c2.setScheduleTime("Wed, 2:00PM - 4:00PM");
		c2.setDescription("This is Description 2");

		CourseBean c3 = new CourseBean();
		c3.setCreated(new Date());
		c3.setName("Course 3");
		c3.setStartDate(start);
		c3.setEndDate(end);
		c3.setEnrollmentCapacity(25);
		c3.setRoom("A3");
		c3.setScheduleTime("Wed, 2:00PM - 4:00PM");
		c3.setDescription("This is Description 3");

		CourseBean c4 = new CourseBean();
		c4.setCreated(new Date());
		c4.setName("Course 4");
		c4.setStartDate(start);
		c4.setEndDate(end);
		c4.setEnrollmentCapacity(25);
		c4.setRoom("A4");
		c4.setScheduleTime("Wed, 2:00PM - 4:00PM");
		c4.setDescription("This is Description 4");

		CourseBean c5 = new CourseBean();
		c5.setCreated(new Date());
		c5.setName("Course 5");
		c5.setStartDate(start);
		c5.setEndDate(end);
		c5.setEnrollmentCapacity(25);
		c5.setRoom("A5");
		c5.setScheduleTime("Wed, 2:00PM - 4:00PM");
		c5.setDescription("This is Description 5");

		// Courses have students
		c1.getStudents().addAll(Arrays.asList(s1, s2, s3));
		c2.getStudents().addAll(Arrays.asList(s2, s3, s4));
		c3.getStudents().addAll(Arrays.asList(s3, s4, s5));
		c4.getStudents().addAll(Arrays.asList(s4, s5, s1));
		c5.getStudents().addAll(Arrays.asList(s5, s1, s2));

		// Courses have textbooks
		c1.getTextbooks().addAll(Arrays.asList(tb1, tb2, tb3));
		c2.getTextbooks().addAll(Arrays.asList(tb2, tb3, tb4));
		c3.getTextbooks().addAll(Arrays.asList(tb3, tb4, tb5));
		c4.getTextbooks().addAll(Arrays.asList(tb4, tb5, tb1));
		c5.getTextbooks().addAll(Arrays.asList(tb5, tb1, tb2));

		
		// subjects have courses and reverse
		sub1.getCourses().add(c1);
		sub2.getCourses().add(c2);
		sub3.getCourses().add(c3);
		sub4.getCourses().add(c4);
		sub5.getCourses().add(c5);
		 
		
		c1.setSubject(sub1);
		c2.setSubject(sub2);
		c3.setSubject(sub3);
		c4.setSubject(sub4);
		c5.setSubject(sub5);


		// teachers have courses and vice versa
		t1.addCourse(c1);
		t1.addCourse(c2);
		t1.addCourse(c3);
//		t2.getCourses().add(c2);
//		t3.getCourses().add(c3);
		t4.addCourse(c4);
		t5.addCourse(c5);
	
		c1.setTeacher(t1);
		c2.setTeacher(t1);
		c3.setTeacher(t1);
		c4.setTeacher(t4);
		c5.setTeacher(t5);
		
		//////
		ApplicationContext context = new ClassPathXmlApplicationContext("dao-beans.xml");

		context.getBean(CourseDAO.class).saveOrUpdate(c1);
		context.getBean(CourseDAO.class).saveOrUpdate(c2);
		context.getBean(CourseDAO.class).saveOrUpdate(c3);
		context.getBean(CourseDAO.class).saveOrUpdate(c4);
		context.getBean(CourseDAO.class).saveOrUpdate(c5);

		context.getBean(SubjectDAO.class).saveOrUpdate(sub1);
		context.getBean(SubjectDAO.class).saveOrUpdate(sub2);
		context.getBean(SubjectDAO.class).saveOrUpdate(sub3);
		context.getBean(SubjectDAO.class).saveOrUpdate(sub4);
		context.getBean(SubjectDAO.class).saveOrUpdate(sub5);

		context.getBean(StudentDAO.class).saveOrUpdate(s1);
		context.getBean(StudentDAO.class).saveOrUpdate(s2);
		context.getBean(StudentDAO.class).saveOrUpdate(s3);
		context.getBean(StudentDAO.class).saveOrUpdate(s4);
		context.getBean(StudentDAO.class).saveOrUpdate(s5);

		context.getBean(TeacherDAO.class).saveOrUpdate(t1);
		context.getBean(TeacherDAO.class).saveOrUpdate(t2);
		context.getBean(TeacherDAO.class).saveOrUpdate(t3);
		context.getBean(TeacherDAO.class).saveOrUpdate(t4);
		context.getBean(TeacherDAO.class).saveOrUpdate(t5);

		System.out.println(context.getBean(TeacherDAO.class).getById(1).getCourses().iterator().next().getSubject().getName());

	}

}