package com.status418.cunyworks.beans;

import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "COURSES")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "courseId")
public class CourseBean {
	@Id
	@Column(name = "COURSE_ID")
	@SequenceGenerator(name = "courseIdSeq", sequenceName = "COURSE_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "courseIdSeq", strategy = GenerationType.SEQUENCE)
	private int courseId;
	@Column(name = "COURSE_ENROLLMENT_CAPACITY")
	private int enrollmentCapacity;
	@Column(name = "COURSE_NAME")
	private String name;
	@Column(name = "COURSE_ROOM")
	private String room;
	@Column(name = "COURSE_SCHEDULE_TIME")
	private String scheduleTime;
	@Column(name = "COURSE_START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name = "COURSE_END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column(name = "COURSE_SYLLABUS")
	private Blob syllabus;
	@Column(name = "COURSE_DESCRIPTION")
	private String description;
	@Column(name = "COURSE_CREATED")
	@Temporal(TemporalType.DATE)
	private Date created;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private SubjectBean subject;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TeacherBean teacher;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<TextbookBean> textbooks = new HashSet<>();
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<StudentBean> students = new HashSet<>();

	public CourseBean() {

	}

	public CourseBean(String name, String room, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public CourseBean(int courseId, String name, String room, Date startDate, Date endDate) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	public CourseBean(int courseId, int enrollmentCapacity, String name, String room, String scheduleTime,
			Date startDate, Date endDate, Blob syllabus, Date created, SubjectBean subject, TeacherBean teacher,
			Set<TextbookBean> textbooks, Set<StudentBean> students) {
		super();
		this.courseId = courseId;
		this.enrollmentCapacity = enrollmentCapacity;
		this.name = name;
		this.room = room;
		this.scheduleTime = scheduleTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.syllabus = syllabus;
		this.created = created;
		this.subject = subject;
		this.teacher = teacher;
		this.textbooks = textbooks;
		this.students = students;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getEnrollmentCapacity() {
		return enrollmentCapacity;
	}

	public void setEnrollmentCapacity(int enrollmentCapacity) {
		this.enrollmentCapacity = enrollmentCapacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.startDate = sdf.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.endDate = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Blob getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(Blob syllabus) {
		this.syllabus = syllabus;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public SubjectBean getSubject() {
		return subject;
	}

	public void setSubject(SubjectBean subject) {
		this.subject = subject;
	}

	public TeacherBean getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherBean teacher) {
		this.teacher = teacher;
	}

	public Set<TextbookBean> getTextbooks() {
		return textbooks;
	}

	public void setTextbooks(Set<TextbookBean> textbooks) {
		this.textbooks = textbooks;
	}

	public Set<StudentBean> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentBean> students) {
		this.students = students;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addTextbook(TextbookBean textbook) {
		this.textbooks.add(textbook);
	}

	public void removeTextbook(TextbookBean textbook) {
		this.textbooks.remove(textbook);
	}

	public void addStudent(StudentBean student) {
		this.students.add(student);
	}

	public void removeStudent(StudentBean student) {
		this.students.remove(student);
	}
	public void copyStartDate(Date date){
		this.startDate = date;
		
	}
	public void copyEndDate(Date date){
		this.endDate = date;
		
	}

	@Override
	public String toString() {
		return "CourseBean [courseId=" + courseId + ", enrollmentCapacity=" + enrollmentCapacity + ", name=" + name
				+ ", room=" + room + ", scheduleTime=" + scheduleTime + ", startDate=" + startDate + ", endDate="
				+ endDate + ", syllabus=" + syllabus + ", description=" + description + ", created=" + created
				+ ", subject=" + subject + "]";
	}

}
