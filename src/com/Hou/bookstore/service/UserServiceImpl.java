package com.Hou.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Hou.bookstore.Dao.UserDao;
import com.Hou.bookstore.Dao.UserDaoImpl;
import com.Hou.bookstore.pojo.User;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

//	public UserServiceImpl() {
//		// TODO Auto-generated constructor stub
//
//		userDao = new UserDaoImpl();
//	}
//	
//	
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}


	@Override
	public User login(User user) { 
		//调用dao 执行查询操作 
		
		User u =userDao.queryUser(user.getUserName(), user.getPassWord());
		
		return u;

	}

	@Override
	public String register(User user) {
		// TODO Auto-generated method stub

		if (userDao.queryUser(user.getUserName())) {
			// 有当前用户名

			return "当前用户名已经存在";

		}
		userDao.insert(user);
		return "success";

	}
	
	public User queryUser(int uid){
		return userDao.queryUser(uid);
	}
	
	@Override
	public void updateInfor(int uid, String nickName) {
		userDao.alertInfor(uid,nickName);
	}
	
}
