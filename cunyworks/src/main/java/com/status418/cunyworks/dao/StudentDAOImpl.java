package com.status418.cunyworks.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.status418.cunyworks.beans.StudentBean;

public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public StudentBean getById(int id) {
		StudentBean student = (StudentBean) sessionFactory.openSession().get(StudentBean.class, id);
		return student;
	}

	@Transactional
	@Override
	public StudentBean getByUsername(String username) {
		StudentBean student = (StudentBean) sessionFactory.getCurrentSession().createCriteria(StudentBean.class)
				.add(Restrictions.eq("email", username)).uniqueResult();
		return student;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Set<StudentBean> getAll() {
		Set<StudentBean> tempSet = new HashSet<>();
		tempSet.addAll(sessionFactory.getCurrentSession().createCriteria(StudentBean.class).list());
		return tempSet;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveOrUpdate(StudentBean student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	@Override
	public void update(StudentBean student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(student);
	}

}
