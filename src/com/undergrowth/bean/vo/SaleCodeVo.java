package com.undergrowth.bean.vo;

import java.sql.Timestamp;

import org.apache.commons.beanutils.BeanUtils;

import com.undergrowth.bean.Eartag;
import com.undergrowth.bean.Salecode;

public class SaleCodeVo {
	
	private String twodimenNo;
	private String tdLocati;
	private String tdSlaugsit;
	private String eartagNo;
	private Timestamp etWdate;
	public String getEartagNo() {
		return eartagNo;
	}
	public void setEartagNo(String eartagNo) {
		this.eartagNo = eartagNo;
	}
	public Timestamp getEtWdate() {
		return etWdate;
	}
	public void setEtWdate(Timestamp etWdate) {
		this.etWdate = etWdate;
	}
	public String getTwodimenNo() {
		return twodimenNo;
	}
	public void setTwodimenNo(String twodimenNo) {
		this.twodimenNo = twodimenNo;
	}
	
	public String getTdLocati() {
		return tdLocati;
	}
	public void setTdLocati(String tdLocati) {
		this.tdLocati = tdLocati;
	}
	public String getTdSlaugsit() {
		return tdSlaugsit;
	}
	public void setTdSlaugsit(String tdSlaugsit) {
		this.tdSlaugsit = tdSlaugsit;
	}
	
	public SaleCodeVo entityToVo(Salecode entity)
	{
		SaleCodeVo vo=new SaleCodeVo();
		try {
			vo.setTwodimenNo(entity.getTwodimenNo());
			vo.setTdLocati(entity.getTdLocati());
			vo.setTdSlaugsit(entity.getTdSlaugsit());
			vo.setEartagNo(entity.getEartag().getId().getEartagNo());
			vo.setEtWdate(entity.getEartag().getId().getEtWdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}
