/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jucheng.ec.app.dao.MenuTypeDefDAO;
import com.jucheng.ec.app.model.MenuType;

@Repository("menuTypeDefDAO")
public class MenuTypeDefDAOImpl extends SqlMapClientDaoSupport implements
		MenuTypeDefDAO {

	public void insert(MenuType menutype) {
		getSqlMapClientTemplate().insert("jucheng_menu_type.insert", menutype);
	}

	@SuppressWarnings("unchecked")
	public List<MenuType> queryMenuList(int storeId) {
		return getSqlMapClientTemplate().queryForList(
				"jucheng_menu_type.queryMenuTypeByStoreId", storeId);
	}

	public int updateMenuType(MenuType menuType) {
		return getSqlMapClientTemplate().update(
				"jucheng_menu_type.updateMenuType", menuType);
	}

	public String getTypeName(int id) {
		MenuType menuType = getMenuType(id);
		if (menuType != null) {
			return menuType.getName();
		}
		return "";
	}

	public MenuType getMenuType(int id) {
		return (MenuType) getSqlMapClientTemplate().queryForObject(
				"jucheng_menu_type.queryMenuTypeById", id);

	}
}