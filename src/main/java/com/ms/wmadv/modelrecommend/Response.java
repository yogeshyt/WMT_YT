package com.ms.wmadv.modelrecommend;

import java.util.List;

public class Response {
	
	private String successMessage;
	
	private String errorMessage;
	
	private Object responseObject;
	
	

	public Response(String successMessage, String errorMessage, List<Product> products) {
		
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.responseObject = products;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	
}
