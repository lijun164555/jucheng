package com.jucheng.ec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jucheng.ec.app.dao.ConfigDefDAO;
import com.jucheng.ec.app.model.ConfigDef;
import com.jucheng.ec.app.model.ConfigDefCriteria;

@Service(value = "systemConfigService")
public class SystemConfigServiceImpl {
	@Autowired
	private transient ConfigDefDAO configDefDAO;

	public ConfigDef getConfigByCode(String code) {
		ConfigDef conf = null;
		ConfigDefCriteria shopExample = new ConfigDefCriteria();

		ConfigDefCriteria.Criteria shopCriteria = shopExample.createCriteria();
		shopCriteria.andCodeEqualTo(code); //code可以唯一确定一条记录
		List<ConfigDef> config = configDefDAO.selectByExample(shopExample);

		if (null != config && config.size() > 0) {
			conf = config.get(0);
		}
		return conf;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3, readOnly = true)
	public String getConfigValueByCode(String code) {

		ConfigDef conf = getConfigByCode(code);

		if (null != conf) {
			return conf.getValue();
		}

		return null;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3, readOnly = true)
	public List<ConfigDef> getAllConfig() {

		ConfigDefCriteria example = new ConfigDefCriteria();
		List<ConfigDef> configList = configDefDAO.selectByExample(example);

		return configList;
	}

}
