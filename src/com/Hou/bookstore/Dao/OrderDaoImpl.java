package com.Hou.bookstore.Dao;

/*
*  @Author : Houlixuan
*  @Description :
*  @Date : Create in 17:36 2017/10/30
*  
 */

import com.Hou.bookstore.pojo.OrderItem;
import com.Hou.bookstore.pojo.Orders;
import com.Hou.bookstore.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl {
	
	public void insertOrders(Orders orders) {
		// TODO Auto-generated method stub
		// 连接 关闭 都由该方法操作
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "INSERT INTO orders value(null,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, ((int)System.currentTimeMillis()+Math.random()*100), orders.getUid(), orders.getAddress()
					, orders.getUserName(), orders.getPhone(), orders.getPrice(),"Underway");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void insertOrderItems(OrderItem orderItem) {
		// TODO Auto-generated method stub
		// 连接 关闭 都由该方法操作
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "INSERT INTO orderitem value(null,?,?,?,?,?)";
		try {
			qr.update(sql, orderItem.getBid(), orderItem.getOid(), orderItem.getBname(),
					orderItem.getNum(), orderItem.getPrice());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Orders> queryOrders(int uid) {
		
		String sql = "select * from orders where uid=?";
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		
		try {
			// BeanListHandler 吧resultset结果集转换成list对象 list元素类型是 booktype
			return qr.query(sql, new BeanListHandler<Orders>(Orders.class), uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public List<OrderItem> queryOrderItems(int oid) {
		
		String sql = "selet * from orderitem where oid=?";
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		
		try {
			// BeanListHandler 吧resultset结果集转换成list对象 list元素类型是 booktype
			return qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public void updateOrder(int oid){
		String sql = "update orders set status=? where oid=?";
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		try {
			qr.update(sql,"OrderCompleted", oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
}
