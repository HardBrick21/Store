package com.Hou.bookstore.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Hou.bookstore.Dao.UserDao;
import com.Hou.bookstore.pojo.User;
import com.Hou.bookstore.service.UserService;
import com.Hou.bookstore.service.UserServiceImpl;
import com.Hou.bookstore.utils.DaoUtils;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {

		super();
		
		ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("applicationContext.xml");

		userservice = (UserService) ca.getBean("userService");

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

		String userName = request.getParameter("userName");

		String passWord = request.getParameter("passWord");

		String code = request.getParameter("code");

		//获取存储的验证码
		String ccode = (String) request.getSession().getAttribute("code");
		
		if (!ccode.equalsIgnoreCase(code) ) {
			//不相等 转发到登陆页面 显示验证码不正确
			
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/jsp/front/login.jsp").forward(request, response);
			
			return;
			
		}
		User u = new User();

		u.setUserName(userName);
		u.setPassWord(passWord);

		User user = userservice.login(u);

		if (user == null) {

			// 登陆失败 转发到登陆页面 提示登录失败
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/jsp/front/login.jsp").forward(request, response);

		} else {

			// 将用户信息放回话到session中
			
			request.getSession().setAttribute("user", user);

			// 登陆成功 重定向到首页

			String path = request.getContextPath();

			response.sendRedirect(path + "/jsp/front/index.jsp");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
