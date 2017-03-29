package com.status418.cunyworks.data;

import java.util.Set;

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

public class FacadeImpl implements Facade {
	private CourseDAO courseDao;
	private StudentDAO studentDao;
	private TeacherDAO teacherDao;
	private SubjectDAO subjectDao;
	private static ApplicationContext context = new ClassPathXmlApplicationContext("dao-beans.xml");

	public FacadeImpl() {

		courseDao = context.getBean(CourseDAO.class);
		studentDao = context.getBean(StudentDAO.class);
		teacherDao = context.getBean(TeacherDAO.class);
		subjectDao = context.getBean(SubjectDAO.class);
	}

	@Override
	public Set<CourseBean> getAllCourse() {
		return courseDao.getAll();
	}

	@Override
	public Set<StudentBean> getAllStudentsByCourse(CourseBean course) {
		return courseDao.getAllStudentsByCourse(course);
	}

	@Override
	public void saveOrUpdate(CourseBean course) {
		courseDao.saveOrUpdate(course);
	}

    @Override
	public void merge(CourseBean course) {
		courseDao.merge(course);
	}
	@Override
	public void delete(CourseBean course) {
		courseDao.delete(course);

	}

	@Override
	public Set<TextbookBean> getTextBooksByCourse(CourseBean course) {
		return courseDao.getTextBooksByCourse(course);
	}

	@Override
	public StudentBean getById(int id) {
		return studentDao.getById(id);
	}

	@Override
	public StudentBean getByUsername(String username) {
		return studentDao.getByUsername(username);
	}

	@Override
	public Set<StudentBean> getAll() {
		return studentDao.getAll();
	}

	@Override
	public void saveOrUpdate(StudentBean student) {
		studentDao.saveOrUpdate(student);
	}

	@Override
	public Set<SubjectBean> getAllSubjects() {
		return subjectDao.getAllSubjects();
	}

	@Override
	public Set<TextbookBean> getAllTextBooksBySubject(String subject) {
		return subjectDao.getAllTextBooksBySubject(subject);
	}

	@Override
	public void saveOrUpdate(SubjectBean subject) {
		subjectDao.saveOrUpdate(subject);
	}

	@Override
	public Set<CourseBean> getAllCoursesBySubject(String subjectName) {
		return subjectDao.getAllCoursesBySubject(subjectName);
	}

	@Override
	public TeacherBean getByTeacherId(int id) {
		return teacherDao.getById(id);
	}

	@Override
	public TeacherBean getByTeacherUsername(String username) {
		return teacherDao.getByUsername(username);
	}

	@Override
	public void saveOrUpdate(TeacherBean teacher) {
		teacherDao.saveOrUpdate(teacher);
	}
	
	@Override
	public CourseBean getCourseById(int id){
		return courseDao.getbyId(id);
	}

	public void update(StudentBean student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}

}
