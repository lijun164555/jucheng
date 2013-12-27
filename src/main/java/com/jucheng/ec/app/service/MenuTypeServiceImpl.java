package com.jucheng.ec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jucheng.ec.app.dao.MenuTypeDefDAO;
import com.jucheng.ec.app.model.MenuType;

@Service(value = "menuTypeService")
public class MenuTypeServiceImpl {
	@Autowired
	private transient MenuTypeDefDAO menuTypeDefDAO;

	/**
	 * 添加菜品类型
	 * 
	 * @param menuType
	 * @return
	 */
	public int insertMenuType(MenuType menuType) {
		menuTypeDefDAO.insert(menuType);
		return 1;
	}

	/**
	 * 查询菜品list
	 * 
	 * @param storeId
	 * @return
	 */
	public List<MenuType> queryMenuList(int storeId) {
		List<MenuType> list = menuTypeDefDAO.queryMenuList(storeId);
		return list;
	}

	/**
	 * 更新菜单类别
	 * 
	 * @param menuType
	 * @return
	 */
	public int updateMenuType(MenuType menuType) {
		return menuTypeDefDAO.updateMenuType(menuType);
	}
}

