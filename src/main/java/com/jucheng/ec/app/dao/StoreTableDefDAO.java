/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao;

import java.util.List;

import com.jucheng.ec.app.model.MenuType;
import com.jucheng.ec.app.model.StoreTable;

public interface StoreTableDefDAO {
	/**
	 * 添加桌子
	 * 
	 * @param storeTable
	 */
	void insert(StoreTable storeTable);

	/**
	 * 查询 一个店铺的桌子
	 * 
	 * @param storeId
	 * @return
	 */
	List<StoreTable> queryTableList(int storeId);

	/**
	 * 更新一个店铺的桌子
	 * 
	 * @param menuType
	 * @return
	 */
	int updateTable(StoreTable storeTable);

	/**
	 * 根据id 查询桌子
	 * 
	 * @param id
	 * @return
	 */
	public StoreTable getTable(int id);

	/**
	 * 查询桌子名称
	 * 
	 * @param id
	 * @return
	 */
	String getTableName(int id);
}