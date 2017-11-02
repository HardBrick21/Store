package com.Hou.bookstore.Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Hou.bookstore.pojo.Book;
import com.Hou.bookstore.pojo.User;
import com.Hou.bookstore.service.BookService;
import com.Hou.bookstore.service.UserService;

import cn.dsna.util.images.ValidateCode;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("bookService")
	private  BookService bookService;

	@RequestMapping("/")
	public String index(Model model) {
		
		//查询图书集合 这里简单的查询了所有服务
		List<Book> books = bookService.getBooks();
		model.addAttribute("hotbooks", books);
		
		return "front/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		System.out.println("--login--");
		// 默认进行转发
		return "front/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User u, String code, HttpSession session, Model model) {

		// 获取存储的验证码
		String ccode = (String) session.getAttribute("code");

		if (!ccode.equalsIgnoreCase(code)) {
			// 不相等 转发到登陆页面 显示验证码不正确
			model.addAttribute("msg", "验证码错误");
			System.out.println("验证码错误" + ccode + code);
			return "front/login";

		}

		User user = userService.login(u);

		if (user == null) {

			// 登陆失败 转发到登陆页面 提示登录失败

			model.addAttribute("msg", "用户名或密码错误");
			System.out.println("用户名或密码错误");
			return "front/login";

		} else {

			// 将用户信息放回话到session中

			session.setAttribute("user", user);
			System.out.println("登陆成功");
			// 登陆成功 重定向到首页

			return "redirect:/";

		}

	}

	/**
	 * 注册
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {

		return "front/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(User user, HttpServletResponse response, HttpServletRequest request, MultipartFile photofile)
			throws IOException, ServletException {

		user.setRole(1);
		user.setDate(new Date(System.currentTimeMillis()));
		
		if (!photofile.isEmpty()){
			String name = photofile.getOriginalFilename();
			String picname = System.currentTimeMillis()+name.substring(name.lastIndexOf("."));
			System.out.println(picname);
			String basepath = "e:\\icon\\";
			File file = new File(basepath+picname);
			
			//将传递来的文件写入到文件中
			
			photofile.transferTo(file);
			user.setPhoto("/icon/" + picname);
		}
		

		// 调用注册服务

		String result = userService.register(user);

		if ("success".equals(result)) {
			// 注册成功 重定向到登陆页面

			String path = request.getContextPath();
			// 延时操作
			response.setContentType("text/html;charset=utf-8");
			response.addHeader("Refresh", "3 ; url=" + path + "/login");
			response.getWriter().write("<h3 注册成功，3秒钟自动跳转...</h3>");

		} else {
			// 注册失败 转发到注册页面

			request.setAttribute("msg", result);
			request.getRequestDispatcher("/WEB-INF/jsp/front/register.jsp").forward(request, response);
			
		}

		System.out.println("zhuce " + result);

	}

	@RequestMapping("/code")
	public void code(HttpSession session, HttpServletResponse response) throws IOException {

		// 设置图片的宽高 字符个数 干扰条数

		ValidateCode vc = new ValidateCode(100, 31, 4, 15);

		// 获取验证码图片中的数据
		String code = vc.getCode();

		// 保存验证码到session中
		session.setAttribute("code", code);
		System.out.println("code=" + code);

		// 向浏览器输出图片数据
		vc.write(response.getOutputStream());
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		// 注销 销毁session对象

		if (session != null) {
			session.invalidate();
		}

		// 重定向到首页

		return "redirect:/";

	}
	
	/* 查看图书详情 */
	@RequestMapping("/bookinfo/{bid}")
	public String bookInfo(@PathVariable("bid") int bid, Model model){
		
		Book book = bookService.getBook(bid);
		
		model.addAttribute("book", book);
		
		return "front/bookinfo";
		
	}
	
	/**
	 * 根据uid查询用户。。
	 * @param uid
	 * @param model
	 * @return 用户对象
	 */
	@RequestMapping("/userCenter/{uid}")
	public String userCenter(@PathVariable("uid") int uid, Model model){
		
		User user = userService.queryUser(uid);
		model.addAttribute("user", user);
		
		return "front/userCenter";
	}
	@RequestMapping(value = "/alertInfor/{uid}", method = RequestMethod.POST)
	public String alertInfor(@PathVariable("uid") int uid, HttpServletRequest request){
		userService.updateInfor(uid,request.getParameter("nickName"));
		return "redirect:/";
	}
	

}
