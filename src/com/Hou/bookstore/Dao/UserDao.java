package com.Hou.bookstore.Dao;

import com.Hou.bookstore.pojo.User;
/**
 * 
 * Dao层只进行数据库操作  不执行业务逻辑
 * @author Administrator
 *
 */
public interface UserDao {
	/**
	 * 插入用户到数据库
	 * @param user
	 */
	
	void insert(User user);
	
	/**
	 * 根据用户名查询
	 * @param name
	 */
	
	boolean queryUser(String name);
	
	
	
	/**
	 * 
	 * 根据用户名或密码 查询用户
	 * @param name
	 * @param password
	 * @return 返回  如果查到用户返回对象 如果没有 返回null；
	 */
	User queryUser(String name, String password);
	
	User queryUser(int uid);
	
	void alertInfor(int uid, String nickName);
	
	
	
}
