package com.undergrowth.bean.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.undergrowth.bean.Eartag;
import com.undergrowth.bean.EartagId;

public class EarTagVo {
	
	private String eartagNo;
	private Timestamp etWdate;
	private String etWdateString;
	public String getEtWdateString() {
		return etWdateString;
	}
	public void setEtWdateString(String etWdateString) {
		this.etWdateString = etWdateString;
	}
	private String etSite;
	private String etAntiepi;
	private String etFeeding;
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
	public String getEtSite() {
		return etSite;
	}
	public void setEtSite(String etSite) {
		this.etSite = etSite;
	}
	public String getEtAntiepi() {
		return etAntiepi;
	}
	public void setEtAntiepi(String etAntiepi) {
		this.etAntiepi = etAntiepi;
	}
	public String getEtFeeding() {
		return etFeeding;
	}
	public void setEtFeeding(String etFeeding) {
		this.etFeeding = etFeeding;
	}
	
	
	//将vo转为entity
	public Eartag voToEntity(EarTagVo vo){
		Eartag eartag=new Eartag();
		EartagId id=new EartagId(vo.getEartagNo(), new Timestamp(new Date().getTime()));
		eartag.setId(id);
		eartag.setEtAntiepi(vo.getEtAntiepi());
		eartag.setEtSite(vo.getEtSite());
		eartag.setEtFeeding(vo.getEtFeeding());
		return eartag;
	}
	//将entity转为vo
	public EarTagVo entityToVo(Eartag entity) {
		// TODO Auto-generated method stub
		EarTagVo earTagVo=new EarTagVo();
		earTagVo.setEartagNo(entity.getId().getEartagNo());
		try {
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			earTagVo.setEtWdate(entity.getId().getEtWdate());
			earTagVo.setEtWdateString(format.format(earTagVo.getEtWdate()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		earTagVo.setEtSite(entity.getEtSite());
		earTagVo.setEtAntiepi(entity.getEtAntiepi());
		earTagVo.setEtFeeding(entity.getEtFeeding());
		return earTagVo;
	}
	
}
