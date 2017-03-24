package com.status418.cunyworks.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.TextbookBean;

public class CourseDAOImpl implements CourseDAO {

	private Session session;

	public CourseDAOImpl() {

	}

	public CourseDAOImpl(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<CourseBean> geAllCourses() {
		Set<CourseBean> courses = new HashSet<CourseBean>();
		courses.addAll(session.createCriteria(CourseBean.class).list());
		return courses;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<StudentBean> getAllStudentsByCourse(CourseBean course) {
		Set<StudentBean> students = new HashSet<StudentBean>();
		students.addAll(session.createCriteria(StudentBean.class).add(Restrictions.eq("course", course)).list());
		return students;
	}

	@Override
	public void saveOrUpdate(CourseBean course) {
		session.saveOrUpdate(course);
	}

	@Override
	public void deleteCourse(CourseBean course) {
		session.delete(course);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<TextbookBean> getTextBooksByCourse(CourseBean course) {
		Set<TextbookBean> textbooks = new HashSet<TextbookBean>();
		textbooks.addAll(session.createCriteria(TextbookBean.class).add(Restrictions.eq("course", course)).list());
		return textbooks;
	}
	
	

}
