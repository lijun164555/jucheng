/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.model;

import java.util.Date;

public class ConfigDef {
	/**
	 * 配置项ID
	 */
	private Long id;

	/**
	 * 配置项编码
	 */
	private String code;

	/**
	 * 配置项名称
	 */
	private String name;

	/**
	 * 配置项值
	 */
	private String value;

	/**
	 * 配置项类型
	 */
	private String type;

	/**
	 * 配置项描述
	 */
	private String description;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 更新日期
	 */
	private Date updateDate;

	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param update_date
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}