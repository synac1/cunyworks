package com.status418.cunyworks.data;

import java.util.Set;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.SubjectBean;
import com.status418.cunyworks.beans.TeacherBean;
import com.status418.cunyworks.beans.TextbookBean;

public interface Facade {

	public Set<CourseBean> getAllCourse();

	public Set<StudentBean> getAllStudentsByCourse(CourseBean course);

	public void saveOrUpdate(CourseBean course);

	public void delete(CourseBean course);

	public Set<TextbookBean> getTextBooksByCourse(CourseBean course);

	public StudentBean getById(int id);

	public StudentBean getByUsername(String username);

	public Set<StudentBean> getAll();

	public void saveOrUpdate(StudentBean student); // Check if this works for
													// removing course

	public Set<SubjectBean> getAllSubjects();

	public Set<TextbookBean> getAllTextBooksBySubject(String subject);

	public void saveOrUpdate(SubjectBean subject);

	public Set<CourseBean> getAllCoursesBySubject(String subjectName);

	public TeacherBean getByTeacherId(int id);

	public TeacherBean getByTeacherUsername(String username);

	public void saveOrUpdate(TeacherBean teacher);

}
