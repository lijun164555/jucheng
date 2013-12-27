/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao;

import java.util.List;

import com.jucheng.ec.app.model.Menu;

public interface MenuDefDAO {

	void insert(Menu menu);
    List<Menu> queryMenuByType(int typeId);
    List<Menu> queryMenuByStoreId(int storeId,int eatType);
    Menu queryMenuById(int id);
    int updateMenu(Menu menu);
    int updateStatus(int id,int status);
}