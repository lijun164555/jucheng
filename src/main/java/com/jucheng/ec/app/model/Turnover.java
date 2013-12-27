package com.jucheng.ec.app.model;

import java.util.Date;

public class Turnover {

	private int id;
	private int storeId;
	private int amount;
	private int billType;
	public int getBillType() {
		return billType;
	}

	public void setBillType(int billType) {
		this.billType = billType;
	}

	private Date gmtCreate;
	private Date gmtModify;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
