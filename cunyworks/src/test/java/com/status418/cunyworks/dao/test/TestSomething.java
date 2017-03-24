package com.status418.cunyworks.dao.test;

import org.hibernate.SessionFactory;

import com.status418.cunyworks.hibernate.HibernateUtil;

public class TestSomething {
	public static void main(String[] args) {
		//Create a session factory using

		SessionFactory sf = HibernateUtil.getSessionFactory();
		sf.openSession();
	}
	

}
