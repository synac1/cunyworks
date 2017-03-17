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
import javax.persistence.SequenceGenerator;

@Entity
public class TextBookBean {
	@Id
	@Column(name="TEXT_BOOK_ID")
	@SequenceGenerator(name = "textBookIdSeq", sequenceName = "TEXTBOOK_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "textBookIdSeq", strategy = GenerationType.SEQUENCE)
	private int textBookId;
	@Column
	private int ISBN;
	@Column(name="TEXT_BOOK_NAME")
	private String textBookName;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "textBooks")
	private Set<SubjectBean> subjects = new HashSet<>();

	public TextBookBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
