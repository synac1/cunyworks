package com.status418.cunyworks.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.hibernate.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	private Session session;

	public StudentDAOImpl() {
		session = sf.openSession();
	}

	@Override
	public StudentBean getStudentById(int id) {
		// TODO Auto-generated method stub

		StudentBean student = (StudentBean) session.load(StudentBean.class, id);
		return student;
	}

	@Override
	public StudentBean getStudentByUsername(String username) {
		// TODO Auto-generated method stub
		StudentBean student = (StudentBean) session.load(StudentBean.class, username);
		return student;
	}

	@Override
	public Set<StudentBean> getAllStudents() {
		// TODO Auto-generated method stub
		return (Set<StudentBean>) session.createCriteria(StudentBean.class).list();
	}

	@Override
	public void updateStudent(StudentBean student) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();

	}

}
