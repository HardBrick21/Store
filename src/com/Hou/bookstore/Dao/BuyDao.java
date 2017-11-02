package com.Hou.bookstore.Dao;

/*
*  @Author : Houlixuan
*  @Description :
*  @Date : Create in 8:49 2017/10/27
*  
 */


import com.Hou.bookstore.pojo.Cart;
import com.Hou.bookstore.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("buyDao")
public class BuyDao {
	
	/**
	 * 插入一条购物记录
	 *
	 * @param cart
	 */
	public void insert(Cart cart) {
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "insert into cart value(null,?,?,?)";
		try {
			qr.update(sql, cart.getBid(), cart.getNum(), cart.getUid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查询某个用户的购物车内容
	 *
	 * @param uid
	 * @return 购物车记集合
	 */
	public List<Cart> queryCart(int uid) {
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "select * from cart,books where cart.bid=books.bid and uid=?";
		try {
			return qr.query(sql, new BeanListHandler<Cart>(Cart.class), uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 查询用户添加到购物车中的某本书
	 *
	 * @param uid
	 * @param bid
	 * @return
	 */
	public Cart queryCart(int uid, int bid) {
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "select * from cart where uid=? and bid=?";
		try {
			return qr.query(sql, new BeanHandler<Cart>(Cart.class), uid, bid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 更改购物车中 某条记录的num值
	 *
	 * @param cid
	 */
	public void upateCart(int cid, int num) {
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "update cart set num=? where cid=?";
		try {
			qr.update(sql, num, cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void clearCart(int uid){
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "DELETE FROM cart WHERE uid =?";
		try {
			qr.update(sql, uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
