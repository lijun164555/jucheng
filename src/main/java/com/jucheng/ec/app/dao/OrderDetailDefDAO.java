/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao;

import java.util.List;

import com.jucheng.ec.app.model.OrderDetail;

public interface OrderDetailDefDAO {

	int insert(OrderDetail orderDetail);
	List<OrderDetail> queryOrderDetailByOrderId(int orderId);
	OrderDetail queryOrderDetailByOrderIdAndMenuId(int orderId,int menuId);
	int update(OrderDetail orderDetail);
}