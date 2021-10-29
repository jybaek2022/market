package gu.market.error;

public enum ErrorCode {
	DuplicatedAccountErrCode(1, "duplicate account error"),
	InvaliddateUserErrCode(2, "invalid user");
	
	private final int errCode;
	private final String errMessage;
	
	ErrorCode(int errCode, String errMessage) {
		this.errCode = errCode;
		this.errMessage = errMessage;
	}
	
	public int getErrCode() {
		return this.errCode;
	}
	
	public String getErrMessage() {
		return this.errMessage;
	}
}
