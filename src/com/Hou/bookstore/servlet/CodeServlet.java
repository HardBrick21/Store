package com.Hou.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

//@WebServlet("/code")

public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CodeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置图片的宽高  字符个数  干扰条数
		
		ValidateCode vc=new ValidateCode(100,31,4,10);
		
		//获取验证码图片中的数据
		String code=vc.getCode();
		
		//保存验证码到session中
		request.getSession().setAttribute("code", code);
		System.out.println("code="+code);
		
		//向浏览器输出图片数据
		vc.write(response.getOutputStream());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
