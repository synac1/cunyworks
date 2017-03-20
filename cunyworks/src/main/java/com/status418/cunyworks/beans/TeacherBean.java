package com.status418.cunyworks.beans;

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
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CourseBean> courses = new HashSet<>();

	public TeacherBean() {

	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<CourseBean> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseBean> courses) {
		this.courses = courses;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "TeacherBean [teacherId=" + teacherId + ", title=" + title + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phone=" + phone + ", address=" + address + ", birthday="
				+ birthday + ", created=" + created + ", courses=" + courses + "]";
	}

}
