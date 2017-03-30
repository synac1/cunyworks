package com.status418.cunyworks.dao;

import java.util.Set;

import com.status418.cunyworks.beans.StudentBean;

public interface StudentDAO {

	public StudentBean getById(int id);

	public StudentBean getByUsername(String username);

	public Set<StudentBean> getAll();

	public void saveOrUpdate(StudentBean student);

	public void merge(StudentBean student);
}
