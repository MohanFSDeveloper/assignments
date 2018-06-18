package com.csp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.csp.custom.annotation.DefaultRegister;
import com.csp.custom.annotation.IsMutation;
import com.csp.custom.annotation.IsReferenceNum;
import com.csp.custom.annotation.IsStartBalance;
import com.csp.custom.annotation.IsUnique;
import com.csp.custom.annotation.IsValidEndBalance;

public class CustomerStatement implements Serializable{

	private static final long serialVersionUID = 1L;

	@DefaultRegister(defaultValue = "N", businessName = "Transaction Reference Number")
	@IsUnique(message = "Duplicate Reference Number Found")
	@IsReferenceNum
	private long transactionRefNumber;
	private String 	accntNumber;
	private String desc;
	@IsStartBalance
	private String startBalance;
	@IsMutation
	private String mutation;
	@DefaultRegister(defaultValue = "N", businessName = "End Balance")
	@IsValidEndBalance(message = "Invalid Endbalance")
	private String endBalance;

	private List<Object> dupReference = new ArrayList<>();

	public void addDupRefrence(Object obj){
		dupReference.add(obj);
	}

	public long getTransactionRefNumber() {
		return transactionRefNumber;
	}
	public void setTransactionRefNumber(long transactionRefNumber) {
		this.transactionRefNumber = transactionRefNumber;
	}
	public String getAccntNumber() {
		return accntNumber;
	}
	public void setAccntNumber(String accntNumber) {
		this.accntNumber = accntNumber;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStartBalance() {
		return startBalance;
	}
	public void setStartBalance(String startBalance) {
		this.startBalance = startBalance;
	}
	public String getMutation() {
		return mutation;
	}
	public void setMutation(String mutation) {
		this.mutation = mutation;
	}
	public String getEndBalance() {
		return endBalance;
	}
	public void setEndBalance(String endBalance) {
		this.endBalance = endBalance;
	}
	@Override
	public String toString() {
		return "CustomerStatement [transactionRefNumber="
				+ transactionRefNumber + ", accntNumber=" + accntNumber
				+ ", desc=" + desc + ", startBalance=" + startBalance
				+ ", mutation=" + mutation + ", endBalance=" + endBalance + "]";
	}
	public List<Object> getDupReference() {
		return dupReference;
	}
	public void setDupReference(List<Object> dupReference) {
		this.dupReference = dupReference;
	}
}
