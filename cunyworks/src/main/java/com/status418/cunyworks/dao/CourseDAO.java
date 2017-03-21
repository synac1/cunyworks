package com.status418.cunyworks.dao;

import java.util.Set;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.TextBookBean;

public interface CourseDAO {

	public Set<CourseBean> geAllCourses();

	public Set<StudentBean> getAllStudentsByCourse(CourseBean course);

	public void saveOrUpdate(CourseBean course);
	
	public void deleteCourse(CourseBean course);
	
	public Set<TextBookBean> getTextBooksByCourse(CourseBean course);
}
