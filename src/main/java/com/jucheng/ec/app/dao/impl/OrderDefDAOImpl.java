/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jucheng.ec.app.dao.OrderDefDAO;
import com.jucheng.ec.app.model.Order;

@Repository("orderDefDAO")
public class OrderDefDAOImpl extends SqlMapClientDaoSupport implements
		OrderDefDAO {

	public int insert(Order order) {
		return (Integer) getSqlMapClientTemplate().insert(
				"jucheng_order.insert", order);
	}

	public Order queryOrderByTable(int table, int storeId) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("tableNum", table);
		map.put("storeId", storeId);
		return (Order) getSqlMapClientTemplate().queryForObject(
				"jucheng_order.queryOrderByTable", map);
	}

	public int updateOrderByid(int id, int totalSum,int is_invoice, int bill_type, int paid_in) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		map.put("totalSum", totalSum);
		map.put("is_invoice", is_invoice);
		map.put("bill_type", bill_type);
		map.put("paid_in", paid_in);
		return getSqlMapClientTemplate().update(
				"jucheng_order.update_pay_status", map);
	}

	public int queryTodayTotalSum() {
		if (getSqlMapClientTemplate().queryForObject(
				"jucheng_order.queryTodayTotalSum") == null) {
			return 0;
		}
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"jucheng_order.queryTodayTotalSum");
	}

	@SuppressWarnings("unchecked")
	public List<Order> queryAllOrderByTable(int table, int storeId) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("tableNum", table);
		map.put("storeId", storeId);
		return (List<Order>) getSqlMapClientTemplate().queryForList(
				"jucheng_order.queryAllOrderByTable", map);
	}
	public Order queryOrderById(int id){
		return (Order) getSqlMapClientTemplate().queryForObject("jucheng_order.queryOrderById",id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> queryAllOrder(int storeId) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("storeId", storeId);
		return (List<Order>) getSqlMapClientTemplate().queryForList(
				"jucheng_order.queryOrder", map);

	}

	@Override
	public int updateOrder(Order order) {
		return getSqlMapClientTemplate().update(
				"jucheng_order.update", order);
	}

}