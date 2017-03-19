package com.status418.cunyworks.dao;

import com.status418.cunyworks.beans.TeacherBean;

public interface TeacherDAO {

	public TeacherBean getTeacherById(int id);

	public TeacherBean getTeacherByUsername(String username);

	public void updateTeacher(TeacherBean teacher);

}
