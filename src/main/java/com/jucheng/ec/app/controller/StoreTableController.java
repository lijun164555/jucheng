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
import com.jucheng.ec.app.model.StoreTable;
import com.jucheng.ec.app.service.StoreTableServiceImpl;

@Controller
public class StoreTableController {

	@Autowired
	protected transient StoreTableServiceImpl storeTableServiceImpl;

	@RequestMapping(value = "/table/table", method = RequestMethod.GET)
	public String menutype(ModelMap model) {
		return "table/table";
	}

	/**
	 * 添加桌子
	 * 
	 * @param name
	 *            类型名称
	 * @param storeId
	 *            门店id
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/table/addtable", method = RequestMethod.GET)
	public String addmenu(String name) throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		StoreTable storeTable = new StoreTable();
		storeTable.setName(name);
		storeTable.setStoreId(1);
		storeTableServiceImpl.insertstoreTable(storeTable);
		return "success";

	}

	/**
	 * 查询
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/table/tablelist", method = RequestMethod.GET)
	public String queryMenuList(ModelMap model) {
		int storeId = 1;
		List<StoreTable> tableList = storeTableServiceImpl
				.queryMenuList(storeId);
		model.addAttribute("tableList", tableList);
		return "table/tablelist";
	}

	/**
	 * 修改
	 * 
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/table/modifytable", method = RequestMethod.GET)
	public String modifyMenu(Model model, int id, String name)
			throws UnsupportedEncodingException {
		model.addAttribute("id", id);
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		model.addAttribute("name", name);
		return "table/modifytable";
	}

	/**
	 * 执行修改 菜单类型
	 * 
	 * @param name
	 * @param stove
	 * @param id
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "table/modifytableaction", method = RequestMethod.GET)
	public String modifymenutypeaction(String name, int id,
			HttpServletResponse response) throws IOException {
		StoreTable storeTable = new StoreTable();
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		storeTable.setId(id);
		storeTable.setName(name);
		storeTableServiceImpl.updatestoreTable(storeTable);
		response.sendRedirect("tablelist");
		return null;
	}

	@RequestMapping(value = "/table", method = RequestMethod.GET)
	@ResponseBody
	public List<StoreTable> queryMenuByStore(int storeId) {
		List<StoreTable> tableList = storeTableServiceImpl
				.queryMenuList(storeId);
		return tableList;
	}
}
