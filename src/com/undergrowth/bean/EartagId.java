package com.undergrowth.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EartagId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class EartagId implements java.io.Serializable {

	// Fields

	private String eartagNo;
	private Timestamp etWdate;

	// Constructors

	/** default constructor */
	public EartagId() {
	}

	/** full constructor */
	public EartagId(String eartagNo, Timestamp etWdate) {
		this.eartagNo = eartagNo;
		this.etWdate = etWdate;
	}

	// Property accessors

	@Column(name = "EARTAG_NO", nullable = false, length = 50)
	public String getEartagNo() {
		return this.eartagNo;
	}

	public void setEartagNo(String eartagNo) {
		this.eartagNo = eartagNo;
	}

	@Column(name = "ET_WDATE", nullable = false, length = 7)
	public Timestamp getEtWdate() {
		return this.etWdate;
	}

	public void setEtWdate(Timestamp etWdate) {
		this.etWdate = etWdate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EartagId))
			return false;
		EartagId castOther = (EartagId) other;

		return ((this.getEartagNo() == castOther.getEartagNo()) || (this
				.getEartagNo() != null && castOther.getEartagNo() != null && this
				.getEartagNo().equals(castOther.getEartagNo())))
				&& ((this.getEtWdate() == castOther.getEtWdate()) || (this
						.getEtWdate() != null && castOther.getEtWdate() != null && this
						.getEtWdate().equals(castOther.getEtWdate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEartagNo() == null ? 0 : this.getEartagNo().hashCode());
		result = 37 * result
				+ (getEtWdate() == null ? 0 : this.getEtWdate().hashCode());
		return result;
	}

}