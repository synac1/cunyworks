package com.status418.cunyworks.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.status418.cunyworks.beans.TeacherBean;

public class TeacherDAOImpl implements TeacherDAO {

	private Session session;
	
	public TeacherDAOImpl(Session session){
		this.session = session;
	}
	
	@Override
	public TeacherBean getTeacherById(int id) {
		Query query = session.createQuery("from TeacherBean where id = :id");
		query.setInteger("id", id);
		TeacherBean teacher = (TeacherBean) query.uniqueResult(); 
		
		return teacher;
	}

	@Override
	public TeacherBean getTeacherByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTeacher(TeacherBean teacher) {
		// TODO Auto-generated method stub

	}

}
