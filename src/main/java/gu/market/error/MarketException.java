package gu.market.error;

public class MarketException extends Exception {
	private ErrorCode errCode;
	private Exception e;
	
	public MarketException(ErrorCode errCode) {
		super();
		this.errCode = errCode;
	}
	
	public MarketException(ErrorCode errCode, Exception e) {
		super();
		this.errCode = errCode;
		this.e = e;
	}
	
	@Override
	public String toString() {
		return errCode.getErrCode() + " : " + errCode.getErrMessage();
	}
}
