/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao;

import java.util.List;

import com.jucheng.ec.app.model.MenuType;

public interface MenuTypeDefDAO {
	/**
	 *  插入菜品类型
	 * 
	 * @param menuType
	 */
	void insert(MenuType menuType);

	/**
	 * 查询 一个店铺的菜品类型
	 * 
	 * @param storeId
	 * @return
	 */
	List<MenuType> queryMenuList(int storeId);

	/**
	 * 更新菜品类型
	 * 
	 * @param menuType
	 * @return
	 */
	int updateMenuType(MenuType menuType);

	/**
	 * 根据id 查询菜单类型
	 * 
	 * @param id
	 * @return
	 */
	public MenuType getMenuType(int id);
	
	 String getTypeName(int id);
}