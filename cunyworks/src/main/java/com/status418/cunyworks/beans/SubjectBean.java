package com.status418.cunyworks.beans;

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
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "SUBJECTS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "subjectId")
public class SubjectBean {
	@Id
	@Column(name = "SUBJECT_ID")
	@SequenceGenerator(name = "subjectIdSeq", sequenceName = "SUBJECT_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "subjectIdSeq", strategy = GenerationType.SEQUENCE)
	private int subjectId;
	@Column(name = "SUBJECT_NAME", nullable = false, unique = true)
	private String name;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)

	@JsonIgnore

	private Set<CourseBean> courses = new HashSet<>();

	public SubjectBean() {

	}

	public SubjectBean(int subjectId, String name, Set<CourseBean> courses) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.courses = courses;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CourseBean> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseBean> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "SubjectBean [subjectId=" + subjectId + ", name=" + name + ", courses=" + courses + "]";
	}

}
