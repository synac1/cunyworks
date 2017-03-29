package com.status418.cunyworks.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.status418.cunyworks.beans.TeacherBean;

public class TeacherDAOImpl implements TeacherDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public TeacherBean getById(int id) {
		return (TeacherBean) sessionFactory.getCurrentSession().get(TeacherBean.class, id);
	}

	@Transactional
	@Override
	public TeacherBean getByUsername(String username) {
		TeacherBean teacher = (TeacherBean) sessionFactory.getCurrentSession().createCriteria(TeacherBean.class)
				.add(Restrictions.eq("email", username)).uniqueResult();
		return teacher;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveOrUpdate(TeacherBean teacher) {
		sessionFactory.getCurrentSession().saveOrUpdate(teacher);
	}
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)

	@Override
	public void merge(TeacherBean teacher) {
		sessionFactory.getCurrentSession().merge(teacher);
		
	}

}
