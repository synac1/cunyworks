package com.status418.cunyworks.dao;

import java.util.Set;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.TextbookBean;

public interface CourseDAO {

	public Set<CourseBean> getAll();

	public Set<StudentBean> getAllStudentsByCourse(CourseBean course);

	public void saveOrUpdate(CourseBean course);

	public void delete(CourseBean course);

	public Set<TextbookBean> getTextBooksByCourse(CourseBean course);

	public CourseBean findById(int id);
}
