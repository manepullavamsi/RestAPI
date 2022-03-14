package com.user.exception;

public class NoData extends RuntimeException {
	
	static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public NoData(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public NoData() {
		super();
	}


}
