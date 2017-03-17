package com.status418.cunyworks.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
public class TeacherBean {
	
	@Id
	@Column
	@SequenceGenerator(name = "teacherIdSeq", sequenceName = "TEACHER_ID_SEQ", allocationSize=1, initialValue=1)
	@GeneratedValue(generator = "teacherIdSeq", strategy = GenerationType.SEQUENCE)
	private int teacherId;
	@Column
	private String title;
	@Column
	private String email;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private int phone;
	@Column
	private String address;
	@Column
	private Date birthday;
	@Column
	private Date created;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<CourseBean> courses = new HashSet<>();

	public TeacherBean() {

		// TODO Auto-generated constructor stub
	}

}
