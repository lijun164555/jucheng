package com.jucheng.ec.app.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jucheng.ec.app.service.PoiService;

@Controller
@RequestMapping("/report")
public class PoiController {

	@Resource(name = "poiService")
	private PoiService service;

	/**
	 * 跳转到主页.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getIndex() {

		return "report";
	}

	/**
	 * 读取excel报表
	 * 
	 * @throws InvalidFormatException
	 */
	@RequestMapping(value = "/menu/read", method = RequestMethod.POST)
	public String getReadReport(@RequestParam MultipartFile file)
			throws IOException, InvalidFormatException {
		service.readReport(file.getInputStream());
		return "success";

	}
}
