package com.status418.cunyworks.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class SubjectBean {
	@Id
	@Column(name = "SUBJECT_ID")
	@SequenceGenerator(name = "subjectIdSeq", sequenceName = "SUBJECT_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "subjectIdSeq", strategy = GenerationType.SEQUENCE)
	private int subjectId;
	@Column(name = "SUBJECT_NAME")
	private String subjectName;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<TextBookBean> textBooks = new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER)
	private Set<CourseBean> courses = new HashSet<>();

	public SubjectBean() {

	}

	public SubjectBean(int subjectId, String subjectName, Set<TextBookBean> textBooks, Set<CourseBean> courses) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.textBooks = textBooks;
		this.courses = courses;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set<TextBookBean> getTextBooks() {
		return textBooks;
	}

	public void setTextBooks(Set<TextBookBean> textBooks) {
		this.textBooks = textBooks;
	}

	public Set<CourseBean> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseBean> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "SubjectBean [subjectId=" + subjectId + ", subjectName=" + subjectName + ", textBooks=" + textBooks
				+ ", courses=" + courses + "]";
	}

}
