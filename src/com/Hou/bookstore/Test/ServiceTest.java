package com.Hou.bookstore.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component("Service")
public class ServiceTest {
	
	@Autowired  //自动搜索内容中同类型的对象
	@Qualifier("Dao")
	private DaoTest dao;

	public void register(){
		
		dao.insert();
	}
	
	public static void main(String[] args) {
		
		//从spring 中 获取daotest对象
		//使用下面的类 来加载解析applicationContext。xml文件
		ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		DaoTest dt = (DaoTest) ca.getBean("dao");
//		
//		dt.insert();
		
		ServiceTest st = (ServiceTest) ca.getBean("Service");
		
		st.register();
		
	}
	
}
