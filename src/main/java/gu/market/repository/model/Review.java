package gu.market.repository.model;

public class Review {

    private int rvno, productNo;
    private String rvtitle, rvwriter, rvmemo, rvfileurl, rvdate;
    private char rvdeleteflag, rvcat;

    public Review() {}
    public Review(int rvno, int productNo, String rvtitle, String rvdate, String rvwriter, String rvmemo, String rvfileurl,
    		char rvdeleteflag, char rvcat) {
    	this.rvno = rvno;
    	this.productNo = productNo;
    	this.rvtitle = rvtitle;
    	this.rvwriter = rvwriter;
    	this.rvmemo = rvmemo;
    	this.rvfileurl = rvfileurl;
    	this.rvdeleteflag = rvdeleteflag;
    	this.rvcat = rvcat;
    	this.rvdate = rvdate;
    }
	public int getRvno() {
		return rvno;
	}
	public void setRvno(int rvno) {
		this.rvno = rvno;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getRvtitle() {
		return rvtitle;
	}
	public void setRvtitle(String rvtitle) {
		this.rvtitle = rvtitle;
	}
	public String getRvwriter() {
		return rvwriter;
	}
	public void setRvwriter(String rvwriter) {
		this.rvwriter = rvwriter;
	}
	public String getRvmemo() {
		return rvmemo;
	}
	public void setRvmemo(String rvmemo) {
		this.rvmemo = rvmemo;
	}
	public String getRvfileurl() {
		return rvfileurl;
	}
	public void setRvfileurl(String rvfileurl) {
		this.rvfileurl = rvfileurl;
	}
	public char getRvdeleteflag() {
		return rvdeleteflag;
	}
	public void setRvdeleteflag(char rvdeleteflag) {
		this.rvdeleteflag = rvdeleteflag;
	}
	public char getRvcat() {
		return rvcat;
	}
	public void setRvcat(char rvcat) {
		this.rvcat = rvcat;
	}
	public String getRvdate() {
		return rvdate;
	}
	public void setRvdate(String rvdate) {
		this.rvdate = rvdate;
	}
    
}