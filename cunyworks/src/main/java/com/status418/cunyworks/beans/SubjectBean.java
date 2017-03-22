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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "SUBJECTS")
public class SubjectBean {
	@Id
	@Column(name = "SUBJECT_ID")
	@SequenceGenerator(name = "subjectIdSeq", sequenceName = "SUBJECT_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "subjectIdSeq", strategy = GenerationType.SEQUENCE)
	private int subjectId;
	@Column(name = "SUBJECT_NAME", nullable = false, unique = true)
	private String name;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "SUBJECTS_TEXTBOOKS")
	private Set<TextbookBean> textbooks = new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CourseBean> courses = new HashSet<>();

	public SubjectBean() {

	}

	public SubjectBean(int subjectId, String name, Set<TextbookBean> textbooks, Set<CourseBean> courses) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.textbooks = textbooks;
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

	public Set<TextbookBean> getTextbooks() {
		return textbooks;
	}

	public void setTextbooks(Set<TextbookBean> textbooks) {
		this.textbooks = textbooks;
	}

	public Set<CourseBean> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseBean> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "SubjectBean [subjectId=" + subjectId + ", name=" + name + ", textbooks=" + textbooks + ", courses="
				+ courses + "]";
	}

}
