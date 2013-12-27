package com.jucheng.ec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jucheng.ec.app.dao.MenuDefDAO;
import com.jucheng.ec.app.dao.MenuTypeDefDAO;
import com.jucheng.ec.app.model.Menu;

@Service(value = "menuService")
public class MenuServiceImpl {
	@Autowired
	private transient MenuDefDAO menuDefDAO;
	@Autowired
	private transient MenuTypeDefDAO menuTypeDefDAO;

	public int insertMenu(Menu menu) {
		menuDefDAO.insert(menu);
		return 1;
	}

	public List<Menu> queryMenuByType(int typeId) {
		return menuDefDAO.queryMenuByType(typeId);
	}

	public List<Menu> queryMenuByStoreId(int storeId,int eatType) {

		List<Menu> list = menuDefDAO.queryMenuByStoreId(storeId,eatType);
		for (Menu menu : list) {
			menu.setTypeName(menuTypeDefDAO.getTypeName(menu.getTypeId()));
		}
		return list;
	}
    public Menu  modifyMenu(int menuId){
    	return menuDefDAO.queryMenuById(menuId);
    }
    public int  modifMenuAction(Menu menu){
    	return menuDefDAO.updateMenu(menu);
    }
    public int deleteMenu(int id,int status){
    	return menuDefDAO.updateStatus(id,status);
    }
}
