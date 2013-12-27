package com.jucheng.ec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jucheng.ec.app.model.ConfigDef;
import com.jucheng.ec.app.service.SystemConfigServiceImpl;

@Controller
public class SystemConfigController {

	@Autowired
	protected transient SystemConfigServiceImpl systemConfigService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String updateSystemConfig(ModelMap model) {
		List<ConfigDef> configs = systemConfigService.getAllConfig();

		model.addAttribute("configs", configs);

		for (ConfigDef configDef : configs) {
			System.out.println(configDef.getName());
		}

		return "test";
	}
}
