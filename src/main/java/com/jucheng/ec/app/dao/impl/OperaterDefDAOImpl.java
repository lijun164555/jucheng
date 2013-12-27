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

import com.jucheng.ec.app.dao.OperaterDefDAO;
import com.jucheng.ec.app.model.Operater;

@Repository("operaterDefDAO")
public class OperaterDefDAOImpl extends SqlMapClientDaoSupport implements
		OperaterDefDAO {

	@Override
	public void insert(Operater operater) {
		getSqlMapClientTemplate().insert("jucheng_operater.insert", operater);
	}

	@Override
	public Operater queryOperaterByPassword(String password,int storeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("storeId", storeId);
		map.put("password", password);
		return (Operater) getSqlMapClientTemplate().queryForObject(
				"jucheng_operater.queryByPassword", map);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operater> queryAllOperater(int storeId) {
		return getSqlMapClientTemplate().queryForList(
				"jucheng_operater.queryall", storeId);
	}

	@Override
	public int updateOperater(Operater operater) {
		return getSqlMapClientTemplate().update(
				"jucheng_operater.updateOperater",operater);
	}

}