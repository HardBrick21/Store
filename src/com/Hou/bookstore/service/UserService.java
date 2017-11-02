package com.Hou.bookstore.service;

import com.Hou.bookstore.pojo.User;

public interface UserService {
	
	/**
	 * 
	 * 提供登陆服务
	 * @param user
	 */
	
	User login(User user);
	
	
	/**
	 * 
	 * 提供注册服务
	 * @param user
	 */
	String register(User user);
	
	User queryUser(int uid);
	
	void updateInfor(int uid, String nickName);

}
