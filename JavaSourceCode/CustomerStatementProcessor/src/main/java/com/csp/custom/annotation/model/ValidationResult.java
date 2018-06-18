package com.csp.custom.annotation.model;

public class ValidationResult {
	
	public ValidationResult( Object transactionRefNumber, String fieldName,
			Object fieldValue,  String errorMessage) {
		super();
		this.transactionRefNumber = transactionRefNumber;
		this.errorMessage = errorMessage;
	}
	private Object transactionRefNumber;
	private String fieldName;
	private Object fieldValue;
	private String errorMessage;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public Object getTransactionRefNumber() {
		return transactionRefNumber;
	}
	public void setTransactionRefNumber(Object transactionRefNumber) {
		this.transactionRefNumber = transactionRefNumber;
	}
	@Override
	public String toString() {
		return "ValidationResult [transactionRefNumber=" + transactionRefNumber
				+ ", fieldName=" + fieldName + ", fieldValue=" + fieldValue
				+ ", errorMessage=" + errorMessage + "]";
	}

		
	
}
