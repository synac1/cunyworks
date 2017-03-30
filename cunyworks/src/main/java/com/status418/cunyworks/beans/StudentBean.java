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
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "STUDENTS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentId")
public class StudentBean {
	@Id
	@Column(name = "STUDENT_ID")
	@SequenceGenerator(name = "studentIdSeq", sequenceName = "STUDENT_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "studentIdSeq", strategy = GenerationType.SEQUENCE)
	private int studentId;
	@Column(name = "STUDENT_EMAIL", nullable = false, unique = true)
	private String email;
	@Column(name = "STUDENT_PASSWORD", nullable = false)
	private String password = "temp";
	@Column(name = "STUDENT_FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "STUDENT_LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "STUDENT_PHONE", unique = true)
	private String phone;
	@Column(name = "STUDENT_ADDRESS")
	private String address;
	@Column(name = "STUDENT_BIRTHDAY", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Column(name = "STUDENT_CREATED")
	@Temporal(TemporalType.DATE)
	private Date created;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "students", cascade = CascadeType.ALL)
	private Set<CourseBean> courses = new HashSet<>();

	public StudentBean() {

	}

	@PrePersist
	protected void onCreate() {
		System.out.println("PrePersit create date");
		created = new Date();
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<CourseBean> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseBean> courses) {
		this.courses = courses;
	}

	public void addCourse(CourseBean course) {
		this.courses.add(course);
	}

	public void removeCourse(CourseBean course) {
		this.courses.remove(course);
	}

	@Override
	public String toString() {
		return "StudentBean [studentId=" + studentId + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phone=" + phone + ", address=" + address + ", birthday="
				+ birthday + ", created=" + created + ", courses=" + courses + "]";
	}

}
