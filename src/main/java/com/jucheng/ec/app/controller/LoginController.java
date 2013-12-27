package com.jucheng.ec.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jucheng.ec.app.model.Operater;
import com.jucheng.ec.app.service.OperaterServiceImpl;

@Controller
public class LoginController {

	@Autowired
	protected transient OperaterServiceImpl operaterService;

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public boolean isOperater(String password, int storeId) {
		Operater operater = operaterService.queryOperaterByPassword(password,
				storeId);
		if (operater != null) {
			return true;
		}
		return false;
	}
}
