package com.Hou.bookstore.service;

/*
*  @Author : Houlixuan
*  @Description :
*  @Date : Create in 9:09 2017/10/27
*  
 */


import com.Hou.bookstore.Dao.BuyDao;
import com.Hou.bookstore.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("buyService")
public class BuyService {
	@Autowired
	@Qualifier("buyDao")
	private BuyDao buyDao;
	
	public void addCart(Cart cart) {
		
		//判断当前用户是否已添加这本书到购物车  如果没有num=1 insert插入
		//如若已经有了这本书 应该修改这本书的num  num+1
		
		Cart c = buyDao.queryCart(cart.getUid(), cart.getBid());
		if (c == null) {
			cart.setNum(1);
			buyDao.insert(cart);
		} else {
			buyDao.upateCart(c.getCid(), c.getNum() + 1);
		}
	}
	
	public List<Cart> getCarts(int uid) {
		return buyDao.queryCart(uid);
	}
	
	public void clearCart(int uid) {
		buyDao.clearCart(uid);
	}
	
	
}
