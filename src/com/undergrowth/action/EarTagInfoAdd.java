package com.undergrowth.action;

import com.undergrowth.bean.Eartag;
import com.undergrowth.bean.service.inter.IEartagDAO;
import com.undergrowth.bean.vo.EarTagVo;

//������Ӷ�����Ϣ

public class EarTagInfoAdd {
	
	
	private EarTagVo earTagVo;
	
	public EarTagVo getEarTagVo() {
		return earTagVo;
	}

	public void setEarTagVo(EarTagVo earTagVo) {
		this.earTagVo = earTagVo;
	}

	private IEartagDAO eartagDAO;
	
	public IEartagDAO getEartagDAO() {
		return eartagDAO;
	}

	public void setEartagDAO(IEartagDAO eartagDAO) {
		this.eartagDAO = eartagDAO;
	}

	//��Ӷ�����Ϣ
	public void add()
	{
		Eartag entityEartag=earTagVo.voToEntity(earTagVo);
		eartagDAO.save(entityEartag);
		
	}
	
	
}
