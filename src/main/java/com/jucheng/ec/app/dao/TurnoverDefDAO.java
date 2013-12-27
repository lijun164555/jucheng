/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao;

import java.util.List;

import com.jucheng.ec.app.model.Turnover;

public interface TurnoverDefDAO {
	/**
	 *  插入当天的营业额
	 * 
	 * @param turnovers
	 */
	void insert(Turnover turnover);

	/**
	 * 查询某点所有营业额
	 * 
	 * @param storeId
	 * @return
	 */
	List<Turnover> queryList(int storeId);

	/**
	 * 更新营业额
	 * 
	 * @param
	 * @return
	 */
	int update(Turnover turnover);

	/**
	 * 查询当天的营业额
	 * 
	 * @param storeId
	 * @return
	 */
	Turnover queryTodayTurnover(int storeId);

}