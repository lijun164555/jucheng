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

import com.jucheng.ec.app.model.Operater;
import com.jucheng.ec.app.service.OperaterServiceImpl;

@Controller
public class OperaterController {

	@Autowired
	protected transient OperaterServiceImpl operaterService;

	/**
	 * 操作员新增页面
	 * 
	 * @return
	 */

	@RequestMapping(value = "/operater/operater", method = RequestMethod.GET)
	public String menutype() {
		return "operater/operater";
	}

	/**
	 * 新增操作员action
	 * 
	 * @param name
	 *            类型名称
	 * @param storeId
	 *            门店id
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/operater/addoperater", method = RequestMethod.GET)
	public String addmenu(String name, String password)
			throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		Operater operater = new Operater();
		operater.setName(name);
		operater.setStoreId(1);
		operater.setPassword(password);
		operaterService.insertOperater(operater);
		return "success";

	}

	/**
	 * 查询操作员列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/operater/operaterlist", method = RequestMethod.GET)
	public String queryMenuList(ModelMap model) {
		int storeId = 1;
		List<Operater> operaterList = operaterService.queryAll(storeId);
		model.addAttribute("operaterList", operaterList);
		return "operater/operaterlist";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/isOperater", method = RequestMethod.GET)
	@ResponseBody
	public boolean isOperater(String password, int storeId) {
		Operater operater = operaterService.queryOperaterByPassword(password,
				storeId);
		if (operater != null) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param storeId
	 * @return
	 */
	@RequestMapping(value = "/queryAllOperater", method = RequestMethod.GET)
	@ResponseBody
	public List<Operater> queryAll(int storeId) {
		return operaterService.queryAll(storeId);
	}

	/**
	 * 修改操作员
	 * 
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/operater/modifyoperater", method = RequestMethod.GET)
	public String modifyMenu(Model model, int operaterId, String name,
			String password) throws UnsupportedEncodingException {
		model.addAttribute("operaterId", operaterId);
		model.addAttribute("password", password);
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		model.addAttribute("name", name);
		return "operater/modifyoperater";
	}

	/**
	 * 执行修改操作员
	 * 
	 * @param name
	 * @param password
	 * @param id
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "operater/modifyoperateraction", method = RequestMethod.GET)
	public String modifymenutypeaction(String name, String password, int id,
			HttpServletResponse response) throws IOException {
		Operater operater = new Operater();
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		operater.setId(id);
		operater.setName(name);
		operater.setPassword(password);
		operaterService.updateOperater(operater);
		response.sendRedirect("operaterlist");
		return null;
	}
}
