package com.status418.cunyworks.dao;

import java.util.Set;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TextBookBean;

public interface SubjectDAO {

	public Set<SubjectBean> getAllSubjects();

	public Set<TextBookBean> getAllTextBooksBySubject(SubjectBean subject);

	public void saveOrUpdate(SubjectBean subject);

	public Set<CourseBean> getAllCoursesBySubject(SubjectBean subject);

}
