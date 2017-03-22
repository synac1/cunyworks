package com.status418.cunyworks.dao;

import java.util.Set;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TextbookBean;

public interface SubjectDAO {

	public Set<SubjectBean> getAllSubjects();

	public Set<TextbookBean> getAllTextBooksBySubject(String subject);

	public void saveOrUpdate(SubjectBean subject);

	Set<CourseBean> getAllCoursesBySubject(String subjectName);

}
