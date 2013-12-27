/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao;

import java.util.List;

import com.jucheng.ec.app.model.Operater;

public interface OperaterDefDAO {

	void insert(Operater operater);

	Operater queryOperaterByPassword(String password, int storeId);

	List<Operater> queryAllOperater(int storeId);
	int updateOperater(Operater operater);
}