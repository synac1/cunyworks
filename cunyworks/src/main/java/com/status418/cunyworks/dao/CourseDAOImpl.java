package com.status418.cunyworks.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.beans.StudentBean;
import com.status418.cunyworks.beans.TextBookBean;

public class CourseDAOImpl implements CourseDAO {

	 private Session session;
	 
	 public CourseDAOImpl(){
		 
	 }
	 public CourseDAOImpl(Session session){
		 this.session=session;
	 }
	@Override
	public Set<CourseBean> geAllCourses() {
		Set<CourseBean> courses = new HashSet<CourseBean>();
		courses =(Set<CourseBean>) session.createCriteria(CourseBean.class).list();
		return courses;
	}

	
	//Does This go here?
	@Override
	public Set<StudentBean> getAllStudentsByCourse(CourseBean course) {

		Set<StudentBean> students= new HashSet<StudentBean>();
		students =(Set<StudentBean>) session.createCriteria(StudentBean.class).add(Restrictions.eq("course", course));
		
		return students;
	}

	@Override
	public void saveOrUpdate(CourseBean course) {
		
		session.saveOrUpdate(course);
		
	}

	@Override
	public void deleteCourse(CourseBean course) {
		session.delete(course);

	}
	@Override
	public Set<TextBookBean> getTextBooksByCourse(CourseBean course) {
		Set<TextBookBean> textbooks= new HashSet<TextBookBean>();
		return textbooks =(Set<TextBookBean>) session.createCriteria(TextBookBean.class).add(Restrictions.eq("course", course)).uniqueResult();
		
	}

}
