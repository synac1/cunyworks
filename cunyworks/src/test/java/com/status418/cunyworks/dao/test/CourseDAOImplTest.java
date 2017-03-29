package com.status418.cunyworks.dao.test;

import org.junit.Test;

import com.status418.cunyworks.beans.CourseBean;
import com.status418.cunyworks.data.FacadeImpl;

public class CourseDAOImplTest {
	
	@Test
	public void getByIdTest(){
		CourseBean c = new FacadeImpl().getCourseById(1);
		System.out.println(c);
		
	}
	

	
}
