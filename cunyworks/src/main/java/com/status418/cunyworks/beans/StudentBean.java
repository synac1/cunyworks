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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="StudentBean")
@NamedQueries({ @NamedQuery(name="getStudentById", query= "from com.status418.cunyworks.beans.StudentBean where id = :param"),
				@NamedQuery(name="getStudentByUsername", query= "from com.status418.cunyworks.beans.StudentBean where username = :param"),
				//@NamedQuery(name="getAllStudents", query= "from com.status418.hibernate.StudentBean")
				})
public class StudentBean {
	@Id
	@Column(name = "STUDENT_ID")
	@SequenceGenerator(name = "studentIdSeq", sequenceName = "STUDENT_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "studentIdSeq", strategy = GenerationType.SEQUENCE)
	private int studentId;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "PHONE")
	private int phone;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "BIRTHDAY", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Column(name = "CREATED")
	@Temporal(TemporalType.DATE)
	private Date created;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<CourseBean> courses = new HashSet<>();

	public StudentBean() {

	}

	@PrePersist
	protected void onCreate() {
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
		return "StudentBean [studentId=" + studentId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phone=" + phone + ", address=" + address + ", birthday=" + birthday + ", created="
				+ created + ", courses=" + courses + "]";
	}

}
