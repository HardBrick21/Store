package com.Hou.bookstore.inter;

/*
*  @Author : Houlixuan
*  @Description : 登陆验证拦截
*  @Date : Create in 10:57 2017/10/27
*  
 */


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoleInter implements HandlerInterceptor {
	//访问到controller之前 调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
		//System.out.println("-----prehander-----");
		String uri = request.getRequestURI();
		if (uri.contains("/buy")){
			Object user = request.getSession().getAttribute("user");
			if (user == null){
				//没登录 转发到登陆页面
				request.getRequestDispatcher("/login").forward(request,httpServletResponse);
				return false;  //中断操作
			}
		}
		return true;
		
		
	}
	
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
	
	}
	
	//Control执行后调用
	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
	
	}
}
