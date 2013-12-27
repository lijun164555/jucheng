/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jucheng.ec.app.dao.MenuDefDAO;
import com.jucheng.ec.app.model.Menu;

@Repository("menuDefDAO")
public class MenuDefDAOImpl extends SqlMapClientDaoSupport implements
		MenuDefDAO {

	public MenuDefDAOImpl() {
		// super().
	}

	public void insert(Menu menu) {
		getSqlMapClientTemplate().insert("jucheng_menu.insert", menu);
	}

	@SuppressWarnings("unchecked")
	public List<Menu> queryMenuByType(int typeId) {
		return getSqlMapClientTemplate().queryForList(
				"jucheng_menu.queryMenuByType", typeId);
	}

	@SuppressWarnings("unchecked")
	public List<Menu> queryMenuByStoreId(int storeId,int eatType) {
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("storeId", storeId);
		map.put("eatType", eatType);
		return getSqlMapClientTemplate().queryForList(
				"jucheng_menu.queryMenuByStoreId", map);
	}

	public Menu queryMenuById(int id) {
		return (Menu) getSqlMapClientTemplate().queryForObject(
				"jucheng_menu.queryMenuById", id);
	}
	public  int updateMenu(Menu menu){
		return getSqlMapClientTemplate().update("jucheng_menu.updateMenu",menu);
	 }
	public  int updateStatus(int id,int status){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", id);
		map.put("status", status);
		return getSqlMapClientTemplate().update("jucheng_menu.updateStatus",map);
	 }

}