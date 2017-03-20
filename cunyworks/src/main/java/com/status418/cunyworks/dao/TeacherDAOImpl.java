package com.status418.cunyworks.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.status418.cunyworks.beans.TeacherBean;

public class TeacherDAOImpl implements TeacherDAO {

	private Session session;

	public TeacherDAOImpl(Session session) {
		this.session = session;
	}

	@Override
	public TeacherBean getTeacherById(int id) {
		return (TeacherBean) session.get(TeacherBean.class, id);
	}

	@Override
	public TeacherBean getTeacherByUsername(String username) {
		TeacherBean teacher = (TeacherBean) session.createCriteria(TeacherBean.class)
				.add(Restrictions.eq("email", username)).uniqueResult();
		return teacher;
	}

	@Override
	public void saveOrUpdateTeacher(TeacherBean teacher) {
		session.saveOrUpdate(teacher);
		
	}

}
