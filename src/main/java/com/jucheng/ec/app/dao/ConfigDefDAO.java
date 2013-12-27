/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao;

import java.util.List;

import com.jucheng.ec.app.model.ConfigDef;
import com.jucheng.ec.app.model.ConfigDefCriteria;

public interface ConfigDefDAO {
	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	int countByExample(ConfigDefCriteria example);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	int deleteByExample(ConfigDefCriteria example);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	void insert(ConfigDef record);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	void insertSelective(ConfigDef record);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	List<ConfigDef> selectByExample(ConfigDefCriteria example);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	ConfigDef selectByPrimaryKey(Long id);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	int updateByExampleSelective(ConfigDef record, ConfigDefCriteria example);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	int updateByExample(ConfigDef record, ConfigDefCriteria example);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	int updateByPrimaryKeySelective(ConfigDef record);

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	int updateByPrimaryKey(final ConfigDef record);
}