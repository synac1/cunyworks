package com.status418.cunyworks.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany
	private Set<TextBookBean> textBooks = new HashSet<>();

	public SubjectBean() {

	}

}
