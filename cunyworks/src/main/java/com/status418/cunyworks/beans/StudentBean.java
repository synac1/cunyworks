package com.status418.cunyworks.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class StudentBean {
	@Id
	@Column
	@SequenceGenerator(name = "studentIdSeq", sequenceName = "STUDENT_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "studentIdSeq", strategy = GenerationType.SEQUENCE)
	private int studentId;
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

	@ManyToMany
	private Set<CourseBean> courses = new HashSet<>();

	public StudentBean() {

	}

}
