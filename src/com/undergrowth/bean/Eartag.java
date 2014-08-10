package com.undergrowth.bean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Eartag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EARTAG", schema = "UNDER")
public class Eartag implements java.io.Serializable {

	// Fields

	private EartagId id;
	private String etSite;
	private String etAntiepi;
	private String etFeeding;
	private Set<Salecode> salecodes = new HashSet<Salecode>(0);

	// Constructors

	/** default constructor */
	public Eartag() {
	}

	/** minimal constructor */
	public Eartag(EartagId id) {
		this.id = id;
	}

	/** full constructor */
	public Eartag(EartagId id, String etSite, String etAntiepi,
			String etFeeding, Set<Salecode> salecodes) {
		this.id = id;
		this.etSite = etSite;
		this.etAntiepi = etAntiepi;
		this.etFeeding = etFeeding;
		this.salecodes = salecodes;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "eartagNo", column = @Column(name = "EARTAG_NO", nullable = false, length = 50)),
			@AttributeOverride(name = "etWdate", column = @Column(name = "ET_WDATE", nullable = false, length = 7)) })
	public EartagId getId() {
		return this.id;
	}

	public void setId(EartagId id) {
		this.id = id;
	}

	@Column(name = "ET_SITE", length = 30)
	public String getEtSite() {
		return this.etSite;
	}

	public void setEtSite(String etSite) {
		this.etSite = etSite;
	}

	@Column(name = "ET_ANTIEPI", length = 100)
	public String getEtAntiepi() {
		return this.etAntiepi;
	}

	public void setEtAntiepi(String etAntiepi) {
		this.etAntiepi = etAntiepi;
	}

	@Column(name = "ET_FEEDING", length = 100)
	public String getEtFeeding() {
		return this.etFeeding;
	}

	public void setEtFeeding(String etFeeding) {
		this.etFeeding = etFeeding;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "eartag")
	public Set<Salecode> getSalecodes() {
		return this.salecodes;
	}

	public void setSalecodes(Set<Salecode> salecodes) {
		this.salecodes = salecodes;
	}

}