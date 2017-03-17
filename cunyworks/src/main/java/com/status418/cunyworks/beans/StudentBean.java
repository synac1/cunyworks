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
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class StudentBean {
	@Id
	@Column(name = "STUDENT_ID")
	@SequenceGenerator(name = "studentIdSeq", sequenceName = "STUDENT_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "studentIdSeq", strategy = GenerationType.SEQUENCE)
	private int studentId;
	@Column(nullable = false)
	private String email;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column
	private int phone;
	@Column
	private String address;
	@Column(nullable = false)
	private Date birthday;
	@Column
	@Temporal(TemporalType.DATE)
	private Date created;
	@ManyToMany
	private Set<CourseBean> courses = new HashSet<>();

	public StudentBean() {

	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

}
