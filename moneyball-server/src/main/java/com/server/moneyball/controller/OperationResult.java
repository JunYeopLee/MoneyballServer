/**
 * 공통모듈
 * @author kimjh
 * 
 */
package com.server.moneyball.controller;

public class OperationResult {

	private boolean success;
	private Object data;
	private String errorCode;
	private String errorMessage;

	public OperationResult() {
	}

	public OperationResult(boolean success) {
		this(success, null, null);
	}

	public OperationResult(boolean success, Object data) {
		this(success, data, null, null);
	}

	public OperationResult(boolean success, String data) {
		this(success, data, null, null);
	}

	public OperationResult(boolean success, String errorCode,
			String errorMessage) {
		this(success, null, errorCode, errorMessage);
	}

	public OperationResult(boolean success, Object data, String errorCode,
			String errorMessage) {
		super();
		this.success = success;
		this.data = data;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public Object getData() {
		return data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
