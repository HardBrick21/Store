package com.Hou.bookstore.service;

/*
*  @Author : Houlixuan
*  @Description :
*  @Date : Create in 17:56 2017/10/30
*  
 */

import com.Hou.bookstore.Dao.BuyDao;
import com.Hou.bookstore.Dao.OrderDaoImpl;
import com.Hou.bookstore.pojo.OrderItem;
import com.Hou.bookstore.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderService {
	
	@Autowired
	@Qualifier("buyDao")
	private BuyDao buyDao;
	
	@Autowired
	@Qualifier("orderDao")
	private OrderDaoImpl orderDao;

	public void addOrder(Orders orders){
	
		
		orderDao.insertOrders(orders);
	
	}
	
	public List<Orders> getOrder(int uid){
		
		return orderDao.queryOrders(uid);
	}
	
	public void update(int oid){
		orderDao.updateOrder(oid);
	}
	
	
	public void addOrderItem(OrderItem orderItem){
		
		orderDao.insertOrderItems(orderItem);
		
	}
	
	public List<OrderItem> getOrderItem(int oid){
		
		return orderDao.queryOrderItems(oid);
	}
	
	
	
}
