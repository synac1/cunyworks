package com.status418.cunyworks.beans;

import java.sql.Blob;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CourseBean {
	@Id
	@Column(name = "COURSE_ID")
	@SequenceGenerator(name = "courseIdSeq", sequenceName = "COURSE_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "courseIdSeq", strategy = GenerationType.SEQUENCE)
	private int courseId;
	@ManyToOne
	private TeacherBean teacher;
	@Column(name = "ENROLLMENT_CAPACITY")
	private int enrollmentCapacity;
	@Column(nullable=false)
	private String name;
	@Column
	private String subject;
	@Column
	private String room;
	@Column(name = "SCHEDULE_TIME")
	private Time scheduleTime;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;
	@Column
	private Blob syllabus;
	@Column
	@Temporal(TemporalType.DATE)
	private Date created;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<TextBookBean> textbooks = new HashSet<>();
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "courses")
	private Set<StudentBean> students = new HashSet<>();

	public CourseBean() {

	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}
}
