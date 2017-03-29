package com.status418.cunyworks.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.TextbookBean;

public class CourseDAOImpl implements CourseDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Set<CourseBean> getAll() {
		Set<CourseBean> courses = new HashSet<CourseBean>();
		courses.addAll(sessionFactory.getCurrentSession().createCriteria(CourseBean.class).list());
		return courses;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Set<StudentBean> getAllStudentsByCourse(CourseBean course) {
		Set<StudentBean> students = new HashSet<StudentBean>();
		students.addAll(sessionFactory.getCurrentSession().createCriteria(StudentBean.class)
				.add(Restrictions.eq("course", course)).list());
		return students;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveOrUpdate(CourseBean course) {
		sessionFactory.getCurrentSession().saveOrUpdate(course);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(CourseBean course) {
		sessionFactory.getCurrentSession().delete(course);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Set<TextbookBean> getTextBooksByCourse(CourseBean course) {
		Set<TextbookBean> textbooks = new HashSet<TextbookBean>();
		textbooks.addAll(sessionFactory.getCurrentSession().createCriteria(TextbookBean.class)
				.add(Restrictions.eq("course", course)).list());
		return textbooks;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public CourseBean getbyId(int id) {
		CourseBean course= (CourseBean) sessionFactory.getCurrentSession().get(CourseBean.class, id);
		return course;
	}
	
	

}
