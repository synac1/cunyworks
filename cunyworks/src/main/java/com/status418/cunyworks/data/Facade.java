package com.status418.cunyworks.data;

import java.util.Set;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TeacherBean;
import com.status418.cunyworks.beans.TextbookBean;

public interface Facade {

	// CourseDAO methods
	public Set<CourseBean> getAllCourses();

	public Set<StudentBean> getAllStudentsByCourse(CourseBean course);

	public void saveOrUpdate(CourseBean course);

	public void delete(CourseBean course);

	public Set<TextbookBean> getTextBooksByCourse(CourseBean course);

	public CourseBean getCourseById(int id);

	public void merge(CourseBean course);
	
	// StudentDAO methods
	public StudentBean getStudentById(int id);

	public StudentBean getStudentByUsername(String username);

	public Set<StudentBean> getAllStudents();

	public void saveOrUpdate(StudentBean student);
	
	public void merge(StudentBean student);
	
	// SubjectDAO Methods
	public Set<SubjectBean> getAllSubjects();

	public Set<TextbookBean> getAllTextBooksBySubject(String subject);

	public void saveOrUpdate(SubjectBean subject);

	public Set<CourseBean> getAllCoursesBySubject(String subjectName);

	public SubjectBean getSubjectById(int id);

	public void merge(SubjectBean subject);
	
	// TeacherDAO methods
	public TeacherBean getTeacherById(int id);

	public TeacherBean getTeacherByUsername(String username);

	public void saveOrUpdate(TeacherBean teacher);
	
	public void merge(TeacherBean teacher);

}
