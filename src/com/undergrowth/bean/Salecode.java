package com.undergrowth.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Salecode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SALECODE", schema = "UNDER")
public class Salecode implements java.io.Serializable {

	// Fields

	private String twodimenNo;
	private Eartag eartag;
	private String tdLocati;
	private String tdSlaugsit;

	// Constructors

	/** default constructor */
	public Salecode() {
	}

	/** minimal constructor */
	public Salecode(String twodimenNo) {
		this.twodimenNo = twodimenNo;
	}

	/** full constructor */
	public Salecode(String twodimenNo, Eartag eartag, String tdLocati,
			String tdSlaugsit) {
		this.twodimenNo = twodimenNo;
		this.eartag = eartag;
		this.tdLocati = tdLocati;
		this.tdSlaugsit = tdSlaugsit;
	}

	// Property accessors
	@Id
	@Column(name = "TWODIMEN_NO", unique = true, nullable = false, length = 50)
	public String getTwodimenNo() {
		return this.twodimenNo;
	}

	public void setTwodimenNo(String twodimenNo) {
		this.twodimenNo = twodimenNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "EARTAG_NO", referencedColumnName = "EARTAG_NO"),
			@JoinColumn(name = "ET_WDATE", referencedColumnName = "ET_WDATE") })
	public Eartag getEartag() {
		return this.eartag;
	}

	public void setEartag(Eartag eartag) {
		this.eartag = eartag;
	}

	@Column(name = "TD_LOCATI", length = 10)
	public String getTdLocati() {
		return this.tdLocati;
	}

	public void setTdLocati(String tdLocati) {
		this.tdLocati = tdLocati;
	}

	@Column(name = "TD_SLAUGSIT", length = 30)
	public String getTdSlaugsit() {
		return this.tdSlaugsit;
	}

	public void setTdSlaugsit(String tdSlaugsit) {
		this.tdSlaugsit = tdSlaugsit;
	}

}