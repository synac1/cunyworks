package com.status418.cunyworks.dao;

import com.status418.cunyworks.beans.TeacherBean;

public interface TeacherDAO {

	public TeacherBean getById(int id);

	public TeacherBean getByUsername(String username);

	public void saveOrUpdate(TeacherBean teacher);
	
	public void merge(TeacherBean teacher);

}
