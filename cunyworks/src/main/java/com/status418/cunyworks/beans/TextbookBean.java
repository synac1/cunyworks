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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "TEXTBOOKS")
public class TextbookBean {
	@Id
	@Column(name = "TEXTBOOK_ID")
	@SequenceGenerator(name = "textbookIdSeq", sequenceName = "TEXTBOOK_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "textbookIdSeq", strategy = GenerationType.SEQUENCE)
	private int textbookId;
	@Column(name = "TEXTBOOK_ISBN")
	private String ISBN;
	@Column(name = "TEXTBOOK_NAME")
	private String name;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "textbooks", cascade = CascadeType.ALL)
	private Set<SubjectBean> subjects = new HashSet<>();

	public TextbookBean() {

	}

	public TextbookBean(int textbookId, String iSBN, String name, Set<SubjectBean> subjects) {
		super();
		this.textbookId = textbookId;
		ISBN = iSBN;
		this.name = name;
		this.subjects = subjects;
	}

	public int getTextbookId() {
		return textbookId;
	}

	public void setTextbookId(int textbookId) {
		this.textbookId = textbookId;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SubjectBean> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<SubjectBean> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "TextbookBean [textbookId=" + textbookId + ", ISBN=" + ISBN + ", name=" + name + ", subjects=" + subjects
				+ "]";
	}

}
