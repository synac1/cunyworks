package com.status418.cunyworks.beans;

import java.sql.Blob;
import java.sql.Time;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "getByCourseId", query = "from CourseBean where courseId = :courseId") })
public class CourseBean {
	@Id
	@Column(name = "COURSE_ID")
	@SequenceGenerator(name = "courseIdSeq", sequenceName = "COURSE_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "courseIdSeq", strategy = GenerationType.SEQUENCE)
	private int courseId;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TeacherBean teacher;
	@Column(name = "ENROLLMENT_CAPACITY", nullable = false)
	private int enrollmentCapacity;
	@Column(nullable = false)
	private String name;
	@ManyToOne
	private SubjectBean subject;
	@Column
	private String room;
	@Column(name = "SCHEDULE_TIME", nullable = false)
	private Time scheduleTime;
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;
	@Column(name = "END_DATE", nullable = false)
	private Date endDate;
	@Column
	private Blob syllabus;
	@Column
	@Temporal(TemporalType.DATE)
	private Date created;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<TextBookBean> textbooks = new HashSet<>();
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "courses", cascade = CascadeType.ALL)
	private Set<StudentBean> students = new HashSet<>();

	public CourseBean() {

	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public TeacherBean getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherBean teacher) {
		this.teacher = teacher;
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

	public SubjectBean getSubject() {
		return subject;
	}

	public void setSubject(SubjectBean subject) {
		this.subject = subject;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Time getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Time scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public Set<TextBookBean> getTextbooks() {
		return textbooks;
	}

	public void setTextbooks(Set<TextBookBean> textbooks) {
		this.textbooks = textbooks;
	}

	public Set<StudentBean> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentBean> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "CourseBean [courseId=" + courseId + ", teacher=" + teacher + ", enrollmentCapacity="
				+ enrollmentCapacity + ", name=" + name + ", subject=" + subject + ", room=" + room + ", scheduleTime="
				+ scheduleTime + ", startDate=" + startDate + ", endDate=" + endDate + ", syllabus=" + syllabus
				+ ", created=" + created + ", textbooks=" + textbooks + ", students=" + students + "]";
	}

}
