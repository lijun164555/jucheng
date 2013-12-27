package com.jucheng.ec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jucheng.ec.app.dao.StoreTableDefDAO;
import com.jucheng.ec.app.model.StoreTable;

@Service(value = "storeTableServiceImpl")
public class StoreTableServiceImpl {
	@Autowired
	private transient StoreTableDefDAO storeTableDefDAO;

	/**
	 * 
	 * 
	 * @param storeTable
	 * @return
	 */
	public int insertstoreTable(StoreTable storeTable) {
		storeTableDefDAO.insert(storeTable);
		return 1;
	}

	/**
	 * 
	 * 
	 * @param storeId
	 * @return
	 */
	public List<StoreTable> queryMenuList(int storeId) {
		List<StoreTable> list = storeTableDefDAO.queryTableList(storeId);
		return list;
	}

	/**
	 * 
	 * 
	 * @param storeTable
	 * @return
	 */
	public int updatestoreTable(StoreTable storeTable) {
		return storeTableDefDAO.updateTable(storeTable);
	}
}

