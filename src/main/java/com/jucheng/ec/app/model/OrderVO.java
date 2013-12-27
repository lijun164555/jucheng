package com.jucheng.ec.app.model;

public class OrderVO {

	private int orderId;
	private int tableNum;
	private int menuId;
	private String menu_name;
	private int price;
	private String type_name;
	private int amount;
	private String menu_secondeName;
	private String menu_thirdName;
	private int headcount;
	private String operaterIds;
	private int orderDetailId;
	private int  eatType;
	
    public int getEatType() {
		return eatType;
	}

	public void setEatType(int eatType) {
		this.eatType = eatType;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	private int payStatus;
	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getHeadcount() {
		return headcount;
	}

	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}

	public String getOperaterIds() {
		return operaterIds;
	}

	public void setOperaterIds(String operaterIds) {
		this.operaterIds = operaterIds;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMenu_secondeName() {
		return menu_secondeName;
	}

	public void setMenu_secondeName(String menu_secondeName) {
		this.menu_secondeName = menu_secondeName;
	}

	public String getMenu_thirdName() {
		return menu_thirdName;
	}

	public void setMenu_thirdName(String menu_thirdName) {
		this.menu_thirdName = menu_thirdName;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	private String pic_url;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

}
