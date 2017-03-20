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

@Entity
public class TextBookBean {
	@Id
	@Column(name = "TEXT_BOOK_ID")
	@SequenceGenerator(name = "textBookIdSeq", sequenceName = "TEXTBOOK_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "textBookIdSeq", strategy = GenerationType.SEQUENCE)
	private int textBookId;
	@Column
	private int ISBN;
	@Column(name = "TEXT_BOOK_NAME")
	private String textBookName;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "textBooks", cascade = CascadeType.ALL)
	private Set<SubjectBean> subjects = new HashSet<>();

	public TextBookBean() {

	}

	public TextBookBean(int textBookId, int iSBN, String textBookName, Set<SubjectBean> subjects) {
		super();
		this.textBookId = textBookId;
		ISBN = iSBN;
		this.textBookName = textBookName;
		this.subjects = subjects;
	}

	public int getTextBookId() {
		return textBookId;
	}

	public void setTextBookId(int textBookId) {
		this.textBookId = textBookId;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTextBookName() {
		return textBookName;
	}

	public void setTextBookName(String textBookName) {
		this.textBookName = textBookName;
	}

	public Set<SubjectBean> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<SubjectBean> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "TextBookBean [textBookId=" + textBookId + ", ISBN=" + ISBN + ", textBookName=" + textBookName
				+ ", subjects=" + subjects + "]";
	}

}
