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
	@Column
	private String title;
	@Column(nullable=false)
	private String email;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column
	private int phone;
	@Column
	private String address;
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date birthday;
	@Column
	@Temporal(TemporalType.DATE)
	private Date created;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<CourseBean> courses = new HashSet<>();

	public TeacherBean() {

	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}
}
