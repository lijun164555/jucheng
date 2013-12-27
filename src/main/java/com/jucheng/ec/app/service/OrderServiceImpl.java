package com.jucheng.ec.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jucheng.ec.app.dao.MenuDefDAO;
import com.jucheng.ec.app.dao.MenuTypeDefDAO;
import com.jucheng.ec.app.dao.OrderDefDAO;
import com.jucheng.ec.app.dao.OrderDetailDefDAO;
import com.jucheng.ec.app.dao.TurnoverDefDAO;
import com.jucheng.ec.app.model.Menu;
import com.jucheng.ec.app.model.Order;
import com.jucheng.ec.app.model.OrderDetail;
import com.jucheng.ec.app.model.OrderVO;
import com.jucheng.ec.app.model.Turnover;

@Service(value = "orderService")
public class OrderServiceImpl {
	@Autowired
	private transient OrderDefDAO orderDefDAO;
	@Autowired
	private transient OrderDetailDefDAO orderDetailDefDAO;
	@Autowired
	private transient MenuDefDAO menuDefDAO;
	@Autowired
	private transient MenuTypeDefDAO menuTypeDefDAO;
	@Autowired
	private transient TurnoverDefDAO turnoverDefDAO;

	public int insertOrder(String dishes, int table, int headcount,
			String userIds) {
		Order order = new Order();
		order.setTableNum(table);
		order.setPayStatus(0);
		order.setStoreId(1);// TODO 接口待完善
		order.setHeadcount(headcount);
		order.setOperaterId(userIds);
		order.setTotalSum(0);
		int id = orderDefDAO.insert(order);
		String[] dish = dishes.split(",");
		for (String menuid : dish) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderId(id);
			orderDetail.setAmount(1);
			String[] dishesAndCount = menuid.split(":");
			if (dishesAndCount.length > 1) {
				orderDetail.setMenuId(Integer.valueOf(dishesAndCount[0]));
				orderDetail.setAmount(Integer.valueOf(dishesAndCount[1]));
			} else {
				orderDetail.setMenuId(Integer.valueOf(dishesAndCount[0]));
				orderDetail.setAmount(1);
			}
			orderDetailDefDAO.insert(orderDetail);
		}
		return id;
	}

	public List<OrderDetail> queryOrderDetailByTable(int table, int storeId) {
		Order order = orderDefDAO.queryOrderByTable(table, storeId);
		if (order == null) {
			return new ArrayList<OrderDetail>();
		}
		return orderDetailDefDAO.queryOrderDetailByOrderId(order.getId());
	}

	public List<OrderVO> queryOrderVOByTable(int table, int storeId) {
		Order order = orderDefDAO.queryOrderByTable(table, storeId);
		if (order == null) {
			return new ArrayList<OrderVO>();
		}
		List<OrderVO> orderVOList = new ArrayList<OrderVO>();
		List<OrderDetail> orderDetailList = orderDetailDefDAO
				.queryOrderDetailByOrderId(order.getId());
		for (OrderDetail orderDetail : orderDetailList) {
			OrderVO orderVO = new OrderVO();
			orderVO.setOrderId(order.getId());
			orderVO.setPayStatus(order.getPayStatus());
			orderVO.setHeadcount(order.getHeadcount());
			orderVO.setOperaterIds(order.getOperaterId());
			orderVO.setTableNum(order.getTableNum());
			orderVO.setMenuId(orderDetail.getMenuId());
			orderVO.setAmount(orderDetail.getAmount());
			orderVO.setOrderDetailId(orderDetail.getId());
			Menu menu = menuDefDAO.queryMenuById(orderDetail.getMenuId());
			if (menu != null) {
				orderVO.setMenu_name(menu.getName());
				orderVO.setPrice(menu.getPrice());
				orderVO.setPic_url(menu.getPicUrl());
				orderVO.setType_name(menuTypeDefDAO.getTypeName(menu
						.getTypeId()));
				orderVO.setMenu_secondeName(menu.getSecondName());
				orderVO.setMenu_thirdName(menu.getThirdName());
				orderVO.setEatType(menu.getEatType());
			}
			orderVOList.add(orderVO);
		}
		return orderVOList;
	}

	public int updateOrderByid(int id,int is_invoice, int bill_type, int paid_in ) {
		List<OrderDetail> list = orderDetailDefDAO
				.queryOrderDetailByOrderId(id);
		int count = 0;
		for (OrderDetail orderDetail : list) {
			Menu menu = menuDefDAO.queryMenuById(orderDetail.getMenuId());
			count = count + menu.getPrice() * orderDetail.getAmount();
		}
		// 统计总金额
		int amount = orderDefDAO.queryTodayTotalSum();
		Turnover turnover = new Turnover();
		turnover.setAmount(amount);
		turnover.setStoreId(1);
		turnoverDefDAO.insert(turnover);
		//
		return orderDefDAO.updateOrderByid(id, count,is_invoice,bill_type,paid_in);
	}

	public int updateOrder(int orderId, String dishes, int headcount,
			String operaterIds) {
		// 更新订单主表
		Order order = orderDefDAO.queryOrderById(orderId);
		order.setHeadcount(headcount);
		if (order.getOperaterId() == null) {
			order.setOperaterId(operaterIds);
		} else if (!operaterIds.contentEquals(order.getOperaterId())) {
			order.setOperaterId(order.getOperaterId() + "," + operaterIds);
		}
		orderDefDAO.updateOrder(order);
		String[] dish = dishes.split(",");
		for (String menuid : dish) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderId(orderId);
			orderDetail.setAmount(1);
			String[] dishesAndCount = menuid.split(":");
			if (dishesAndCount.length > 1) {
				// 根据订单号和菜品id查询
				OrderDetail updateOrderDetail = orderDetailDefDAO
						.queryOrderDetailByOrderIdAndMenuId(orderId,
								Integer.valueOf(dishesAndCount[0]));
				if (updateOrderDetail != null) {
					updateOrderDetail.setAmount(updateOrderDetail.getAmount()
							+ Integer.valueOf(dishesAndCount[1]));
					orderDetailDefDAO.update(updateOrderDetail);
					return 1;
				}
				orderDetail.setMenuId(Integer.valueOf(dishesAndCount[0]));
				orderDetail.setAmount(Integer.valueOf(dishesAndCount[1]));
			} else {
				// 根据订单号和菜品id查询
				OrderDetail updateOrderDetail = orderDetailDefDAO
						.queryOrderDetailByOrderIdAndMenuId(orderId,
								Integer.valueOf(dishesAndCount[0]));
				if (updateOrderDetail != null) {
					updateOrderDetail.setAmount(updateOrderDetail.getAmount()
							+ Integer.valueOf(dishesAndCount[1]));
					orderDetailDefDAO.update(updateOrderDetail);
					return 1;
				}
				orderDetail.setMenuId(Integer.valueOf(dishesAndCount[0]));
				orderDetail.setAmount(1);
			}
			orderDetailDefDAO.insert(orderDetail);
		}
		return 1;
	}

	public int todayCount() {
		return orderDefDAO.queryTodayTotalSum();
	}

	public List<Order> queryAllOrderByTable(int table, int storeId) {
		List<Order> orderList = orderDefDAO
				.queryAllOrderByTable(table, storeId);
		return orderList;
	}

	public List<Order> queryAllOrder(int storeId) {
		List<Order> orderList = orderDefDAO.queryAllOrder(storeId);
		return orderList;
	}

	public List<OrderVO> queryAllOrderVOByTable(int id) {
		Order order = orderDefDAO.queryOrderById(id);
		List<OrderVO> orderVOList = new ArrayList<OrderVO>();
		List<OrderDetail> orderDetailList = orderDetailDefDAO
				.queryOrderDetailByOrderId(id);
		for (OrderDetail orderDetail : orderDetailList) {
			OrderVO orderVO = new OrderVO();
			orderVO.setOrderId(order.getId());
			orderVO.setTableNum(order.getTableNum());
			orderVO.setMenuId(orderDetail.getMenuId());
			orderVO.setAmount(orderDetail.getAmount());
			Menu menu = menuDefDAO.queryMenuById(orderDetail.getMenuId());
			if (menu != null) {
				orderVO.setMenu_name(menu.getName());
				orderVO.setPrice(menu.getPrice());
				orderVO.setPic_url(menu.getPicUrl());
				orderVO.setType_name(menuTypeDefDAO.getTypeName(menu
						.getTypeId()));
			}
			orderVOList.add(orderVO);
		}
		return orderVOList;
	}

	public boolean isBill(int table, int storeId) {
		Order order = orderDefDAO.queryOrderByTable(table, storeId);
		if (order == null || order.getPayStatus() == 1) {
			return true;
		}
		return false;
	}

	public void modfiyOrderDetail(String str, int orderId) {
		String[] dish = str.split(",");
		for (String menuid : dish) {
			String[] dishesAndCount = menuid.split(":");
			OrderDetail updateOrderDetail = orderDetailDefDAO
					.queryOrderDetailByOrderIdAndMenuId(orderId,
							Integer.valueOf(dishesAndCount[0]));
			updateOrderDetail.setAmount(Integer.valueOf(dishesAndCount[1]));
			orderDetailDefDAO.update(updateOrderDetail);
		}

	}
	public List<OrderVO> queryOrderVOById(int orderId) {
		Order order = orderDefDAO.queryOrderById(orderId);
		if (order == null) {
			return new ArrayList<OrderVO>();
		}
		List<OrderVO> orderVOList = new ArrayList<OrderVO>();
		List<OrderDetail> orderDetailList = orderDetailDefDAO
				.queryOrderDetailByOrderId(order.getId());
		for (OrderDetail orderDetail : orderDetailList) {
			OrderVO orderVO = new OrderVO();
			orderVO.setOrderId(order.getId());
			orderVO.setPayStatus(order.getPayStatus());
			orderVO.setHeadcount(order.getHeadcount());
			orderVO.setOperaterIds(order.getOperaterId());
			orderVO.setTableNum(order.getTableNum());
			orderVO.setMenuId(orderDetail.getMenuId());
			orderVO.setAmount(orderDetail.getAmount());
			orderVO.setOrderDetailId(orderDetail.getId());
			Menu menu = menuDefDAO.queryMenuById(orderDetail.getMenuId());
			if (menu != null) {
				orderVO.setMenu_name(menu.getName());
				orderVO.setPrice(menu.getPrice());
				orderVO.setPic_url(menu.getPicUrl());
				orderVO.setType_name(menuTypeDefDAO.getTypeName(menu
						.getTypeId()));
				orderVO.setMenu_secondeName(menu.getSecondName());
				orderVO.setMenu_thirdName(menu.getThirdName());
			}
			orderVOList.add(orderVO);
		}
		return orderVOList;
	}

}
