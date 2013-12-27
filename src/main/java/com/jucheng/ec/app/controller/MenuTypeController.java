package com.jucheng.ec.app.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jucheng.ec.app.model.MenuType;
import com.jucheng.ec.app.service.MenuTypeServiceImpl;

@Controller
public class MenuTypeController {

	@Autowired
	protected transient MenuTypeServiceImpl menuTypeService;

	@RequestMapping(value = "/menutype/menutype", method = RequestMethod.GET)
	public String menutype(ModelMap model) {
		return "menutype/menutype";
	}

	/**
	 * 添加菜单类型
	 * 
	 * @param name
	 *            类型名称
	 * @param storeId
	 *            门店id
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/menutype/addmenutype", method = RequestMethod.GET)
	public String addmenu(String name, String stove)
			throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		MenuType menuType = new MenuType();
		menuType.setName(name);
		menuType.setStoreId(1);
		menuType.setStove(stove);
		menuTypeService.insertMenuType(menuType);
		return "success";

	}

	/**
	 * 查询菜单类型
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/menutype/menutypelist", method = RequestMethod.GET)
	public String queryMenuList(ModelMap model) {
		int storeId = 1;
		List<MenuType> menuTypeList = menuTypeService.queryMenuList(storeId);
		model.addAttribute("menuTypeList", menuTypeList);
		return "menutype/menutypelist";
	}
	/**
	 * 修改菜单类型
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/menutype/modifymenutype", method = RequestMethod.GET)
	public String modifyMenu(Model model,int menuTypeId,String name,String stove) throws UnsupportedEncodingException {
		model.addAttribute("menuTypeId",menuTypeId);
		model.addAttribute("stove",stove);
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		model.addAttribute("name",name);
		return "menutype/modifymenutype";
	}
	/**
	 * 执行修改 菜单类型
	 * @param name
	 * @param stove
	 * @param id
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "menutype/modifymenutypeaction", method = RequestMethod.GET)
	public String modifymenutypeaction(String name, String stove,int id ,HttpServletResponse response) throws IOException {
		MenuType menuType=new MenuType();
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		menuType.setId(id);
		menuType.setName(name);
		menuType.setStove(stove);
		menuTypeService.updateMenuType(menuType);
		response.sendRedirect("menutypelist");
		return null;
	}
	@RequestMapping(value = "/queryMenuType", method = RequestMethod.GET)
	@ResponseBody
	public List<MenuType> queryMenuByStore(int storeId) {
		List<MenuType> menuTypeList = menuTypeService.queryMenuList(storeId);
		return menuTypeList;
	}
}
