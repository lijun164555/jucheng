/**
 * Copyright © 2001-2010
 * iSoftStone Information Technology ( Group ) Co., Ltd.
 */
package com.jucheng.ec.app.dao;

import java.util.List;

import com.jucheng.ec.app.model.Order;

public interface OrderDefDAO {
	/**
	 * 插入订单
	 * 
	 * @param order
	 * @return
	 */
	int insert(Order order);

	/**
	 * 查询某店某桌子最新订单
	 * 
	 * @param table
	 * @param storeId
	 * @return
	 */
	Order queryOrderByTable(int table, int storeId);

	/**
	 * 更新订单 结账
	 * 
	 * @param id
	 * @param totalSum
	 * @return
	 */

	int updateOrderByid(int id, int totalSum,int is_invoice, int bill_type, int paid_in);

	/**
	 * 查询当日营业额
	 * 
	 * @return
	 */
	int queryTodayTotalSum();

	/**
	 * 查询某店某桌子的所有订单
	 * 
	 * @param table
	 * @param storeId
	 * @return
	 */
	List<Order> queryAllOrderByTable(int table, int storeId);

	/**
	 * 根据订单id查询订单
	 * 
	 * @param id
	 * @return
	 */
	Order queryOrderById(int id);
	List<Order> queryAllOrder( int storeId);
	/**
	 * 
	 * @param id
	 * @param totalSum
	 * @return
	 */
	int updateOrder(Order order);
}