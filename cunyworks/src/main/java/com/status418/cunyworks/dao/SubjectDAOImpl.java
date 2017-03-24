package com.status418.cunyworks.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TextbookBean;

public class SubjectDAOImpl implements SubjectDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Set<SubjectBean> getAllSubjects() {
		Set<SubjectBean> result = new HashSet<>();
		ArrayList<SubjectBean> allSubject = (ArrayList<SubjectBean>) sessionFactory.getCurrentSession()
				.createCriteria(SubjectBean.class).list();
		result.addAll(allSubject);
		return result;
	}
	
	@Transactional
	@Override
	public Set<TextbookBean> getAllTextBooksBySubject(String subject) {
		SubjectBean subjectObj = (SubjectBean) sessionFactory.getCurrentSession().createCriteria(SubjectBean.class)
				.add(Restrictions.eq("name", subject)).uniqueResult();
		Set<TextbookBean> result = new HashSet<>();
		for (CourseBean cB : subjectObj.getCourses()) {
			result.addAll(cB.getTextbooks());
		}
		return result;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveOrUpdate(SubjectBean subject) {
		sessionFactory.getCurrentSession().saveOrUpdate(subject);
	}

	@Transactional
	@Override
	public Set<CourseBean> getAllCoursesBySubject(String subjectName) {
		SubjectBean subjectObj = (SubjectBean) sessionFactory.getCurrentSession().createCriteria(SubjectBean.class)
				.add(Restrictions.eq("name", subjectName)).uniqueResult();
		Set<CourseBean> result = subjectObj.getCourses();
		return result;

	}

}
