package com.api.task.entity;

public class ResponseErrorCreate{
	private boolean error;
	private String errorMessage;

	public ResponseErrorCreate(boolean error, String errorMessage) {
		this.error = error;
		this.errorMessage = errorMessage;
	}

	public ResponseErrorCreate(String already_exist) {
	}

	@Override
	public String toString() {
		return "ResponseErrorCreate{" +
				"error=" + error +
				", errorMessage='" + errorMessage + '\'' +
				'}';
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
