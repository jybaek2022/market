package gu.market.dto;

import java.util.List;

import gu.market.repository.model.MissingPet;

public class MissingPetResponse {
//	@json("list")
	private List<MissingPet> result;
//	@json("totalCount")
	private int totalCount;
//	@json("pageNo")
	private int pageNo;
	
	public MissingPetResponse(List<MissingPet> result, int totalCount, int pageNo) {
		this.result = result;
		this.totalCount = totalCount;
		this.pageNo = pageNo;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public List<MissingPet> getResult() {
		return result;
	}
	public void setResult(List<MissingPet> result) {
		this.result = result;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
