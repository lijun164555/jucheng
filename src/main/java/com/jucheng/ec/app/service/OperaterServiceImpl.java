package com.jucheng.ec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jucheng.ec.app.dao.OperaterDefDAO;
import com.jucheng.ec.app.model.Operater;

@Service(value = "operaterService")
public class OperaterServiceImpl {
	@Autowired
	private transient OperaterDefDAO operaterDefDAO;

	public Operater queryOperaterByPassword(String password, int storeId) {
		return operaterDefDAO.queryOperaterByPassword(password, storeId);
	}

	public List<Operater> queryAll(int storeId) {
		return operaterDefDAO.queryAllOperater(storeId);
	}

	public void insertOperater(Operater operater) {
		operaterDefDAO.insert(operater);
	}

	public int updateOperater(Operater operater) {
		return operaterDefDAO.updateOperater(operater);
	}

}
