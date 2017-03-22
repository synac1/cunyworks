package com.status418.cunyworks.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TextbookBean;

public class SubjectDAOImpl implements SubjectDAO {

	private Session session;

	public SubjectDAOImpl(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<SubjectBean> getAllSubjects() {
		Set<SubjectBean> result = new HashSet<>();
		ArrayList<SubjectBean> allSubject = (ArrayList<SubjectBean>) session.createCriteria(SubjectBean.class).list();
		result.addAll(allSubject);
		return result;
	}

	@Override
	public Set<TextbookBean> getAllTextBooksBySubject(String subject) {
		SubjectBean subjectObj = (SubjectBean) session.createCriteria(SubjectBean.class)
				.add(Restrictions.eq("name", subject)).uniqueResult();
		Set<TextbookBean> result = subjectObj.getTextbooks();
		return result;
	}

	@Override
	public void saveOrUpdate(SubjectBean subject) {
		session.saveOrUpdate(subject);
	}

	@Override
	public Set<CourseBean> getAllCoursesBySubject(String subjectName) {
		SubjectBean subjectObj = (SubjectBean) session.createCriteria(SubjectBean.class)
				.add(Restrictions.eq("name", subjectName)).uniqueResult();
		Set<CourseBean> result = subjectObj.getCourses();
		return result;

	}

}
