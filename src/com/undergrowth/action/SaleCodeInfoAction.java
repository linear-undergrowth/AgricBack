package com.undergrowth.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.e;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.undergrowth.bean.Eartag;
import com.undergrowth.bean.Salecode;
import com.undergrowth.bean.service.inter.IEartagDAO;
import com.undergrowth.bean.service.inter.ISalecodeDAO;
import com.undergrowth.bean.vo.EarTagVo;
import com.undergrowth.bean.vo.SaleCodeVo;

/*
 * 用于处理二维码的action
 */

public class SaleCodeInfoAction {
	
	private String twodimen_no;
	

	public String getTwodimen_no() {
		return twodimen_no;
	}

	public void setTwodimen_no(String twodimen_no) {
		this.twodimen_no = twodimen_no;
	}

	private ISalecodeDAO salecodeDAO;

	public ISalecodeDAO getSalecodeDAO() {
		return salecodeDAO;
	}

	public void setSalecodeDAO(ISalecodeDAO salecodeDAO) {
		this.salecodeDAO = salecodeDAO;
	}
	
	private IEartagDAO eartagDAO;
	
	
	
	public IEartagDAO getEartagDAO() {
		return eartagDAO;
	}

	public void setEartagDAO(IEartagDAO eartagDAO) {
		this.eartagDAO = eartagDAO;
	}

	public void getSaleCodeInfo()
	{
		SaleCodeVo vo=new SaleCodeVo();
		Salecode entity=salecodeDAO.findById(twodimen_no);
		vo=vo.entityToVo(entity);
		try {  
            //获取响应response  
            HttpServletResponse response=ServletActionContext.getResponse();  
            //设置响应的内容类型  
            response.setContentType("application/json;charset=utf-8");  
            //获取输出流  
            PrintWriter pw=response.getWriter(); 
            String jsonString=fillJsonData(vo);  
    		//System.out.println(jsonString+" "+twodimen_no);
            pw.write(jsonString);  
            pw.flush();  
            pw.close();  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
	}

	private String fillJsonData(SaleCodeVo vo) {
		// TODO Auto-generated method stub
		String jsonString=null;
		JSONObject object=JSONObject.fromObject(vo);
		jsonString=object.toString();
		return jsonString;
	}
	
	
	public void getSaleCodeEarTagInfo()
	{
		SaleCodeVo vo=new SaleCodeVo();
		Salecode entity=salecodeDAO.findById(twodimen_no);
		List<Eartag> eartags=eartagDAO.findByProperty("id.eartagNo", entity.getEartag().getId().getEartagNo());
		List<EarTagVo> earTagVos=changeEntityToVos(eartags); 
		try {  
            //获取响应response  
            HttpServletResponse response=ServletActionContext.getResponse();  
            //设置响应的内容类型  
            response.setContentType("application/json;charset=utf-8");  
            //获取输出流  
            PrintWriter pw=response.getWriter(); 
            String jsonString=fillJsonData(earTagVos);  
    		//System.out.println(jsonString+" "+twodimen_no);
            pw.write(jsonString);  
            pw.flush();  
            pw.close();  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
	}
	
	private String fillJsonData(List<EarTagVo> earTagVos) {
		// TODO Auto-generated method stub
		String jsonString=null;
		JSONArray object=JSONArray.fromObject(earTagVos);
		jsonString=object.toString();
		return jsonString;
	}

	private List<EarTagVo> changeEntityToVos(List<Eartag> eartags){
		List<EarTagVo> earTagVos=new ArrayList<>();
		for (Iterator iterator = eartags.iterator(); iterator.hasNext();) {
			Eartag earTag = (Eartag) iterator.next();
			EarTagVo earTagVo=new EarTagVo();
			earTagVo=earTagVo.entityToVo(earTag); 
			earTagVos.add(earTagVo);
		}
		return earTagVos;
	}
	
}
