package com.status418.cunyworks.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.status418.cunyworks.beans.StudentBean;

public class StudentDAOImpl implements StudentDAO {

	private Session session;

	public StudentDAOImpl(Session session) {
		this.session = session;
	}

	@Override
	public StudentBean getStudentById(int id) {
		StudentBean student = (StudentBean) session.load(StudentBean.class, id);
		return student;
	}

	@Override
	public StudentBean getStudentByUsername(String username) {
		StudentBean student = (StudentBean) session.createCriteria(StudentBean.class)
				.add(Restrictions.eq("email", username)).uniqueResult();
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<StudentBean> getAllStudents() {
		Set<StudentBean> tempSet = new HashSet<>();
		tempSet.addAll(session.createCriteria(StudentBean.class).list());
		return tempSet;
	}

	@Override
	public void updateStudent(StudentBean student) {
		session.saveOrUpdate(student);
	}

}
