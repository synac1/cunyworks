package com.status418.cunyworks.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TeacherBean {

	@Id
	@Column(name = "TEACHER_ID")
	@SequenceGenerator(name = "teacherIdSeq", sequenceName = "TEACHER_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "teacherIdSeq", strategy = GenerationType.SEQUENCE)
	private int teacherId;
	@Column(name = "TITLE", nullable = false)
	private String title;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "PHONE")
	private int phone;
	@Column(name = "ADDRESS")
	private String address;
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", nullable = false)
	private Date birthday;
	@Column(name = "CREATED")
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	
	@OneToMany
	private Set<CourseBean> courses = new HashSet<>();

	public TeacherBean() {

	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}
}
