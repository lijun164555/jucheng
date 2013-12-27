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

import com.jucheng.ec.app.dao.OrderDetailDefDAO;
import com.jucheng.ec.app.model.OrderDetail;

@Repository("orderDetailDefDAO")
public class OrderDetailDefDAOImpl extends SqlMapClientDaoSupport implements OrderDetailDefDAO {

     
	public int insert(OrderDetail orderDetail) {
		return  (Integer)getSqlMapClientTemplate().insert("jucheng_order_detail.insert", orderDetail);
	}
	@SuppressWarnings("unchecked")
	public List<OrderDetail> queryOrderDetailByOrderId(int orderId) {
		return	getSqlMapClientTemplate().queryForList("jucheng_order_detail.queryOrderDetailByOrderId",orderId);
	}
	@Override
	public OrderDetail queryOrderDetailByOrderIdAndMenuId(int orderId,int menuId) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("orderId", orderId);
		map.put("menuId", menuId);
		return	(OrderDetail)getSqlMapClientTemplate().queryForObject("jucheng_order_detail.queryOrderDetailByOrderIdAndMenuId",map);
	}
	@Override
	public int update(OrderDetail orderDetail) {
    	getSqlMapClientTemplate().update("jucheng_order_detail.update",orderDetail);
		return 1;
	}
}