package gu.market.error;

public enum ErrorCode {
	// HTTP Response
	// HTTP Response > Status Code : 400
	// HTTP Response > Body : {"errCode": 1, "errMessage": "duplicate account error"}
	
	DuplicatedAccountErrCode(1, "duplicate account error"),
	InvaliddateUserErrCode(2, "invalid user"),
	UnloginedStatus(3, "unlogined"),
	ShortStock(4, "short stock");
	
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
