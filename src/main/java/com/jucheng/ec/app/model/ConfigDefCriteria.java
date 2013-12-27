/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigDefCriteria {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public ConfigDefCriteria() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	protected ConfigDefCriteria(ConfigDefCriteria example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
		this.distinct = example.distinct;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * TODO 请替换成正确注释(例如使用右键菜单:Source -> Generate Element Comment)
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * TODO 请填写正确的类注释
	 * @author iSoftStone GADS
	 * @since Tue Nov 08 14:54:17 CST 2011
	 */
	protected abstract static class GeneratedCriteria {
		protected List<String> criteriaWithoutValue;

		protected List<Map<String, Object>> criteriaWithSingleValue;

		protected List<Map<String, Object>> criteriaWithListValue;

		protected List<Map<String, Object>> criteriaWithBetweenValue;

		protected GeneratedCriteria() {
			super();
			criteriaWithoutValue = new ArrayList<String>();
			criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
			criteriaWithListValue = new ArrayList<Map<String, Object>>();
			criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0 || criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0 || criteriaWithBetweenValue.size() > 0;
		}

		public List<String> getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List<Map<String, Object>> getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List<Map<String, Object>> getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List<Map<String, Object>> getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition, List<? extends Object> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			List<Object> list = new ArrayList<Object>();
			list.add(value1);
			list.add(value2);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("code is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("code is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("code =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("code <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("code >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("code >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("code <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("code <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("code like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("code not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("code in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("code not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("code between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("code not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andValueIsNull() {
			addCriterion("value is null");
			return (Criteria) this;
		}

		public Criteria andValueIsNotNull() {
			addCriterion("value is not null");
			return (Criteria) this;
		}

		public Criteria andValueEqualTo(String value) {
			addCriterion("value =", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotEqualTo(String value) {
			addCriterion("value <>", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThan(String value) {
			addCriterion("value >", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThanOrEqualTo(String value) {
			addCriterion("value >=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThan(String value) {
			addCriterion("value <", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThanOrEqualTo(String value) {
			addCriterion("value <=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLike(String value) {
			addCriterion("value like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotLike(String value) {
			addCriterion("value not like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueIn(List<String> values) {
			addCriterion("value in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotIn(List<String> values) {
			addCriterion("value not in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueBetween(String value1, String value2) {
			addCriterion("value between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotBetween(String value1, String value2) {
			addCriterion("value not between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("description not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNull() {
			addCriterion("update_date is null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNotNull() {
			addCriterion("update_date is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateEqualTo(Date value) {
			addCriterion("update_date =", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotEqualTo(Date value) {
			addCriterion("update_date <>", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThan(Date value) {
			addCriterion("update_date >", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("update_date >=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThan(Date value) {
			addCriterion("update_date <", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
			addCriterion("update_date <=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIn(List<Date> values) {
			addCriterion("update_date in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotIn(List<Date> values) {
			addCriterion("update_date not in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateBetween(Date value1, Date value2) {
			addCriterion("update_date between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
			addCriterion("update_date not between", value1, value2, "updateDate");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}
}