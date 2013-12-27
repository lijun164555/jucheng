package com.jucheng.ec.app.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jucheng.ec.app.dao.OrderDefDAO;
import com.jucheng.ec.app.model.Order;
import com.jucheng.ec.app.model.OrderDetail;
import com.jucheng.ec.app.model.OrderVO;
import com.jucheng.ec.app.service.OrderServiceImpl;

@Controller
public class OrderController {

	@Autowired
	protected transient OrderServiceImpl orderService;
	@Autowired
	private transient OrderDefDAO orderDefDAO;
    /**
     * 新增订单的接口
     * @param dishes
     * @param table
     * @param headcount
     * @param operaterIds
     * @return
     */
	@RequestMapping(value = "/addorder", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addOrder(String dishes, int table,int headcount,String operaterIds) {
		int orderId=orderService.insertOrder(dishes, table, headcount, operaterIds);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "下单成功！");
		map.put("orderId", orderId);
		return map;
	}

	@RequestMapping(value = "/queryorder", method = RequestMethod.GET)
	@ResponseBody
	public List<OrderDetail> queryOrder(int table) {
		int storeId = 1;
		return orderService.queryOrderDetailByTable(table, storeId);
	}

	@RequestMapping(value = "/queryordervo", method = RequestMethod.GET)
	@ResponseBody
	public List<OrderVO> queryOrderVO(int table) {
		int storeId = 1;
		return orderService.queryOrderVOByTable(table, storeId);
	}

	@RequestMapping(value = "/querycurrentorder", method = RequestMethod.GET)
	public String queryOrder() {
		return "querycurrentorder";
	}

	@RequestMapping(value = "/orderlist", method = RequestMethod.GET)
	public String orderlist(ModelMap model, int table) {
		int storeId = 1;
		List<OrderVO> orderVOList = orderService.queryOrderVOByTable(table,
				storeId);
		if(orderVOList==null){
			return "empty";
		}
		for(OrderVO orderVO:orderVOList){
			if(orderVO.getPayStatus()==1){
				return "empty";
			}
		}
		int count = 0;
		int orderId = 0;
		for (OrderVO orderVO : orderVOList) {

			count = count + orderVO.getPrice() * orderVO.getAmount();
			orderId = orderVO.getOrderId();
		}
		model.addAttribute("orderVOList", orderVOList);
		model.addAttribute("count", count);
		model.addAttribute("table", table);
		model.addAttribute("orderId", orderId);
		return "orderlist";
	}

	/**
	 * 结账
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public String bill(int orderId) {
		//orderService.updateOrderByid(orderId);
		return "success";
	}

	/**
	 * 更新订单 加菜
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/updateorder", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> updateOrder(int orderId, String dishes,int headcount,String operaterIds) {
		orderService.updateOrder(orderId, dishes,headcount,operaterIds);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "下单成功！");
		return map;
	}

	/**
	 * 统计今日销售额
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/todaycount", method = RequestMethod.GET)
	public String todaycount(ModelMap model) {
		model.addAttribute("totalCount", orderService.todayCount());
		return "todaycount";
	}

	/**
	 * 查询某桌全部订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/order/queryallorderbytable", method = RequestMethod.GET)
	public String queryallOrderBytable() {
		return "querycurrentorder";
	}

	/**
	 * 展示某桌全部订单列表
	 * 
	 * @param model
	 * @param table
	 * @return
	 */
	@RequestMapping(value = "/order/orderlist", method = RequestMethod.GET)
	public String orderList(ModelMap model, int table) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int storeId = 1;
		List<Order> list = orderService.queryAllOrderByTable(table, storeId);
		for (Order order : list) {
       order.setShowCreatDate(s.format(order.getGmtCreate()));
       order.setShowModifyDate(s.format(order.getGmtModify()));
		}
		model.addAttribute("orderList", list); 
		return "order/orderlist";
	}

	@RequestMapping(value = "/order/orderdetaillist", method = RequestMethod.GET)
	public String allOrderlist(ModelMap model, int id, int table) {
		List<OrderVO> orderVOList = orderService.queryAllOrderVOByTable(id);
		int count = 0;
		int orderId = 0;
		for (OrderVO orderVO : orderVOList) {

			count = count + orderVO.getPrice() * orderVO.getAmount();
			orderId = orderVO.getOrderId();
		}
		model.addAttribute("orderVOList", orderVOList);
		model.addAttribute("count", count);
		model.addAttribute("table", table);
		model.addAttribute("orderId", orderId);
		return "orderlist";
	}

	/**
	 * 结账
	 * 
	 * @param orderId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/order/bill", method = RequestMethod.GET)
	public String billorder(int orderId,int is_invoice, int bill_type, String paid_in ,HttpServletResponse response) throws IOException {
		int paid_in_int=(int)Double.parseDouble(paid_in)*100;
		orderService.updateOrderByid(orderId,is_invoice,bill_type,paid_in_int);
		
		response.sendRedirect("print?orderId="+orderId);
		return null;
	}

	@RequestMapping(value = "/data/data", method = RequestMethod.GET)
	public String data() {
		// orderService.updateOrderByid(orderId);
		return "data/data";
	}

	/**
	 * 是否结账
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/isbill", method = RequestMethod.GET)
	@ResponseBody
	public boolean isBill(int table) {
		int storeId = 1;
		return orderService.isBill(table, storeId);
	}
	/**
	 * 
	 */
	@RequestMapping(value = "/order/allorder", method = RequestMethod.GET)
	public String allorder(ModelMap model) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int storeId = 1;
		List<Order> list = orderService.queryAllOrder(storeId);
		for (Order order : list) {
       order.setShowCreatDate(s.format(order.getGmtCreate()));
       order.setShowModifyDate(s.format(order.getGmtModify()));
		}
		model.addAttribute("orderList", list);
		return "order/allorder";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/modifyOrderDetail", method = RequestMethod.GET)
	public String  modify(ModelMap model,String modifyAll,int orderId) {
		orderService.modfiyOrderDetail(modifyAll, orderId);
		return "success";
	}
	
	/**
	 * 展示某桌全部订单列表
	 * 
	 * @param model
	 * @param table
	 * @return
	 */
	@RequestMapping(value = "/order/billlist", method = RequestMethod.GET)
	public String billList(ModelMap model, int table) {
		int storeId = 1;
		List<OrderVO> orderVOList = orderService.queryOrderVOByTable(table,
				storeId);
		int count = 0;
		int orderId = 0;
		for (OrderVO orderVO : orderVOList) {

			count = count + orderVO.getPrice() * orderVO.getAmount();
			orderId = orderVO.getOrderId();
		}
		Order order=orderDefDAO.queryOrderById(orderId);
		if(order==null){
			return "/order/billlist";
		}
		model.addAttribute("orderVOList", orderVOList);
		model.addAttribute("count", count);
		model.addAttribute("table", table);
		model.addAttribute("orderId", orderId);
		model.addAttribute("payStatus", order.getPayStatus());
		model.addAttribute("is_invoice", order.getIs_invoice());
		//
		String  billType="";
		if(order.getBill_type()==0){
			billType="现金";
		}else if(order.getBill_type()==1){
			billType="信用卡";
		}else if(order.getBill_type()==2){
			billType="会员消费";
		}else if(order.getBill_type()==3){
			billType="内招";
		}
		model.addAttribute("billType",billType);
		model.addAttribute("paid_in", order.getPaidIn());
		return "order/billlist";
	}
	/**
	 * 展示某桌全部订单列表
	 * 
	 * @param model
	 * @param table
	 * @return
	 */
	@RequestMapping(value = "/order/print", method = RequestMethod.GET)
	public String printOrder(ModelMap model, int orderId) {
		List<OrderVO> orderVOList = orderService.queryOrderVOById(orderId);
		int count = 0;
		for (OrderVO orderVO : orderVOList) {

			count = count + orderVO.getPrice() * orderVO.getAmount();
			orderId = orderVO.getOrderId();
		}
		Order order=orderDefDAO.queryOrderById(orderId);
		model.addAttribute("orderVOList", orderVOList);
		model.addAttribute("count", count);
		model.addAttribute("table", order.getTableNum());
		model.addAttribute("orderId", orderId);
		model.addAttribute("payStatus", order.getPayStatus());
		model.addAttribute("is_invoice", order.getIs_invoice());
		//
		String  billType="";
		if(order.getBill_type()==0){
			billType="现金";
		}else if(order.getBill_type()==1){
			billType="信用卡";
		}else if(order.getBill_type()==2){
			billType="会员消费";
		}else if(order.getBill_type()==3){
			billType="内招";
		}
		model.addAttribute("billType",billType);
		model.addAttribute("paid_in", order.getPaidIn());
		return "order/print";
	}
}
