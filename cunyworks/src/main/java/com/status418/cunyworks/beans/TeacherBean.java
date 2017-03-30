package com.status418.cunyworks.beans;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "TEACHERS")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="teacherId")
public class TeacherBean {

	@Id
	@Column(name = "TEACHER_ID")
	@SequenceGenerator(name = "teacherIdSeq", sequenceName = "TEACHER_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "teacherIdSeq", strategy = GenerationType.SEQUENCE)
	private int teacherId;
	@Column(name = "TEACHER_TITLE", nullable = false)
	private String title;
	@Column(name = "TEACHER_EMAIL", nullable = false, unique = true)
	private String email;
	@Column(name = "TEACHER_FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "TEACHER_LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "TEACHER_PHONE", unique = true)
	private String phone;
	@Column(name = "TEACHER_ADDRESS")
	private String address;
	@Temporal(TemporalType.DATE)
	@Column(name = "TEACHER_BIRTHDAY", nullable = false)
	private Date birthday;
	@Column(name = "TEACHER_CREATED")
	@Temporal(TemporalType.DATE)
	private Date created;
	@Column(name = "TEACHER_PASSWORD", nullable = false)
	@JsonIgnore
	private String password;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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

	public void setBirthday(String birthday) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.birthday = sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<CourseBean> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseBean> courses) {
		this.courses = courses;
	}

	public void addCourse(CourseBean course){
		this.courses.add(course);
	}
	
	public void removeCourse(CourseBean course) {
		this.courses.remove(course);
	}
	
	@Override
	public String toString() {
		return "TeacherBean [teacherId=" + teacherId + ", title=" + title + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phone=" + phone + ", address=" + address + ", birthday="
				+ birthday + ", created=" + created + ", password=" + password + ", courses=" + courses + "]";
	}

}
