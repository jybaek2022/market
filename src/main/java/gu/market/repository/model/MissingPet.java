package gu.market.repository.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MissingPet {
	private String careNm;
	private String careAddr;
	private String kindCd;
	private String sexCd;
	private String popfile;
	private int pageNo;
	private int totalCount;
	
	public MissingPet() {}
	public MissingPet(String careNm, String careAddr,
			String kindCd, String sexCd, String popfile, int pageNo, int totalCount){
		this.careNm = careNm;
		this.careAddr = careAddr;
		this.kindCd = kindCd;
		this.sexCd = sexCd;
		this.popfile = popfile;
		this.pageNo = pageNo;
		this.totalCount = totalCount;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getCareNm() {
		return careNm;
	}
	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}
	public String getCareAddr() {
		return careAddr;
	}
	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}
	public String getKindCd() {
		return kindCd;
	}
	public void setKindCd(String kindCd) {
		this.kindCd = kindCd;
	}
	public String getSexCd() {
		return sexCd;
	}
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	public String getPopfile() {
		return popfile;
	}
	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}

}
