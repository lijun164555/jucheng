package com.jucheng.ec.app.model;

import java.util.Date;

public class MenuType {

	private int id;
	private String name;
	private int storeId;
	private String stove;
	private Date gmtCreate;
	private Date gmtModify;

	public String getStove() {
		return stove;
	}

	public void setStove(String stove) {
		this.stove = stove;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
