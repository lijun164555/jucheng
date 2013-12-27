/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jucheng.ec.app.dao.TurnoverDefDAO;
import com.jucheng.ec.app.model.Turnover;

@Repository("turnoverDefDAO")
public class TurnoverDefDAOImpl extends SqlMapClientDaoSupport implements
		TurnoverDefDAO {

	public void insert(Turnover turnover) {
		getSqlMapClientTemplate().insert("jucheng_turnover.insert", turnover);
	}

	@SuppressWarnings("unchecked")
	public List<Turnover> queryList(int storeId) {
		return getSqlMapClientTemplate().queryForList(
				"jucheng_turnover.queryallByStoreId", storeId);
	}

	public int update(Turnover turnover) {
		return getSqlMapClientTemplate().update(
				"jucheng_turnover.updateTurnover", turnover);
	}

	public Turnover queryTodayTurnover(int storeId) {
		return (Turnover) getSqlMapClientTemplate().queryForObject(
				"jucheng_turnover.queryTurnoverByStoreId", storeId);
	}

}