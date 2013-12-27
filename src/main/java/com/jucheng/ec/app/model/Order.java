package com.jucheng.ec.app.model;

import java.util.Date;

public class Order {

	private int id;
	private int tableNum;
	private int payStatus;
	private Date gmtCreate;
	private Date gmtModify;
	private int storeId;
	private String showCreatDate;
	private String showModifyDate;
	private int headcount;
	private String operaterId;
	private int totalSum;
	private int paidIn;
	private int is_invoice;
	private int bill_type;

	public int getPaidIn() {
		return paidIn;
	}

	public void setPaidIn(int paidIn) {
		this.paidIn = paidIn;
	}

	public int getIs_invoice() {
		return is_invoice;
	}

	public void setIs_invoice(int is_invoice) {
		this.is_invoice = is_invoice;
	}

	public int getBill_type() {
		return bill_type;
	}

	public void setBill_type(int bill_type) {
		this.bill_type = bill_type;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	public int getHeadcount() {
		return headcount;
	}

	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}

	public String getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(String operaterId) {
		this.operaterId = operaterId;
	}

	public String getShowCreatDate() {
		return showCreatDate;
	}

	public void setShowCreatDate(String showCreatDate) {
		this.showCreatDate = showCreatDate;
	}

	public String getShowModifyDate() {
		return showModifyDate;
	}

	public void setShowModifyDate(String showModifyDate) {
		this.showModifyDate = showModifyDate;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

}
