/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jucheng.ec.app.dao.ConfigDefDAO;
import com.jucheng.ec.app.model.ConfigDef;
import com.jucheng.ec.app.model.ConfigDefCriteria;

@Repository("configDefDAO")
public class ConfigDefDAOImpl extends SqlMapClientDaoSupport implements ConfigDefDAO {

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public ConfigDefDAOImpl() {
		super();
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public int countByExample(ConfigDefCriteria example) {
		Integer count = (Integer) getSqlMapClientTemplate()
				.queryForObject("tbl_sys_config_def.countByExample", example);
		return count;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public int deleteByExample(ConfigDefCriteria example) {
		int rows = getSqlMapClientTemplate().delete("tbl_sys_config_def.deleteByExample", example);
		return rows;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public int deleteByPrimaryKey(Long id) {
		ConfigDef _key = new ConfigDef();
		_key.setId(id);
		int rows = getSqlMapClientTemplate().delete("tbl_sys_config_def.deleteByPrimaryKey", _key);
		return rows;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public void insert(ConfigDef record) {
		getSqlMapClientTemplate().insert("tbl_sys_config_def.insert", record);
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public void insertSelective(ConfigDef record) {
		getSqlMapClientTemplate().insert("tbl_sys_config_def.insertSelective", record);
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	@SuppressWarnings("unchecked")
	public List<ConfigDef> selectByExample(ConfigDefCriteria example) {
		List<ConfigDef> list = getSqlMapClientTemplate().queryForList("selectByExample", example);
		return list;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public ConfigDef selectByPrimaryKey(Long id) {
		ConfigDef _key = new ConfigDef();
		_key.setId(id);
		ConfigDef record = (ConfigDef) getSqlMapClientTemplate().queryForObject(
				"tbl_sys_config_def.selectByPrimaryKey", _key);
		return record;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public int updateByExampleSelective(ConfigDef record, ConfigDefCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("tbl_sys_config_def.updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public int updateByExample(ConfigDef record, ConfigDefCriteria example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update("tbl_sys_config_def.updateByExample", parms);
		return rows;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public int updateByPrimaryKeySelective(ConfigDef record) {
		int rows = getSqlMapClientTemplate().update("tbl_sys_config_def.updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public int updateByPrimaryKey(ConfigDef record) {
		int rows = getSqlMapClientTemplate().update("tbl_sys_config_def.updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * TODO 请填写正确的类注释
	 * @author iSoftStone GADS
	 * @since Tue Nov 08 14:54:17 CST 2011
	 */
	protected static class UpdateByExampleParms extends ConfigDefCriteria {
		private Object record;

		public UpdateByExampleParms(Object record, ConfigDefCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}