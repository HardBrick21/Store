package com.Hou.bookstore.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hou.bookstore.Dao.UserDaoImpl;
import com.Hou.bookstore.pojo.User;
import com.Hou.bookstore.service.UserService;
import com.Hou.bookstore.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {

		super();
		// TODO Auto-generated constructor stub

		userService = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		// 设置处理请求的编码

		request.setCharacterEncoding("utf-8");

		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String nickName = request.getParameter("nickName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");

		// 创建一个User对象

		User user = new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setNickName(nickName);
		user.setEmail(email);
		user.setGender(gender);
		user.setDate(new Date(System.currentTimeMillis()));

		// 调用注册服务

		String result = userService.register(user);

		if ("success".equals(result)) {
			// 注册成功 重定向到登陆页面

			String path = request.getContextPath();
			//response.sendRedirect(path + "/jsp/front/login.jsp");
			//延时操作
			
			
			response.setContentType("text/html;charset=utf-8");
			response.addHeader("Refresh", "3 ; url="+path +"/jsp/front/login.jsp");
			response.getWriter().write("注册成功，3秒钟自动跳转...");
		
		} else {
			// 注册失败 转发到注册页面
			
			request.setAttribute("msg", result);
			request.getRequestDispatcher("/jsp/front/register.jsp").forward(request, response);
			;

		}

		System.out.println("zhuce " + result);

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
