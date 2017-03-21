package com.status418.cunyworks.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TextBookBean;
import com.status418.cunyworks.hibernate.HibernateUtil;

public class SubjectDAOImpl implements SubjectDAO {

	private Session session;

	public SubjectDAOImpl(Session session) {

		this.session= session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<SubjectBean> getAllSubjects() {
		Set<SubjectBean> result = new HashSet<>();
		ArrayList<SubjectBean> allSubject = (ArrayList<SubjectBean>) session.createCriteria(SubjectBean.class).list();
		result.addAll(allSubject);
		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<TextBookBean> getAllTextBooksBySubject(SubjectBean subject) {

//		
//		SubjectBean subjectObj = (SubjectBean) session.createCriteria(SubjectBean.class)
//				.add(Restrictions.eq("subjectName",subject)).uniqueResult();
		Set<TextBookBean>result = subject.getTextBooks();
		
		
		return result;
	}

	@Override
	public void saveOrUpdate(SubjectBean subject) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(subject);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<CourseBean> getAllCoursesBySubject(SubjectBean subjectObj) {
		
		Set<CourseBean>result = subjectObj.getCourses();
		
		
		return result;
	}

}
