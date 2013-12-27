/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jucheng.ec.app.dao.StoreTableDefDAO;
import com.jucheng.ec.app.model.MenuType;
import com.jucheng.ec.app.model.StoreTable;

@Repository("storeTableDefDAO")
public class StoreTableDefDAOImpl extends SqlMapClientDaoSupport implements
		StoreTableDefDAO {

	public void insert(StoreTable storeTable) {
		getSqlMapClientTemplate().insert("jucheng_store_table.insert",
				storeTable);

	}

	@SuppressWarnings("unchecked")
	public List<StoreTable> queryTableList(int storeId) {
		return getSqlMapClientTemplate().queryForList(
				"jucheng_store_table.queryStoreTableByStoreId", storeId);
	}

	public int updateTable(StoreTable storeTable) {
		return getSqlMapClientTemplate().update(
				"jucheng_store_table.updateStoreTable", storeTable);
	}

	public String getTableName(int id) {
		StoreTable storeTable = getTable(id);
		if (storeTable != null) {
			return storeTable.getName();
		}
		return "";
	}

	public StoreTable getTable(int id) {
		return (StoreTable) getSqlMapClientTemplate().queryForObject(
				"jucheng_store_table.queryStoreTableById", id);
	}
}