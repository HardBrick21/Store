package com.Hou.bookstore.Controller;

/*
*  @Author : Houlixuan
*  @Description :
*  @Date : Create in 18:48 2017/10/30
*  
 */

import com.Hou.bookstore.pojo.Cart;
import com.Hou.bookstore.pojo.Orders;
import com.Hou.bookstore.pojo.User;
import com.Hou.bookstore.service.BuyService;
import com.Hou.bookstore.service.OrderService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
	
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
	@Autowired
	@Qualifier("buyService")
	private BuyService buyService;
	
	@RequestMapping(value = "/order")
	public String order(Model model, HttpSession session, HttpServletRequest request) {
		User u = (User) session.getAttribute("user");
		
		List<Cart> cart = buyService.getCarts(u.getUid());
		model.addAttribute("cart", cart);
		model.addAttribute("user", u);
		model.addAttribute("money", request.getParameter("money"));
		return "front/orders";
	}
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String addOrder(Model model, HttpSession session, Orders orders, HttpServletRequest request) {

		User u = (User) session.getAttribute("user");
		orders.setUid(u.getUid());
		String price = request.getParameter("money");
		orders.setPrice(price);
		orderService.addOrder(orders);
		buyService.clearCart(u.getUid());
		model.addAttribute("orders", orders);
		return "forward:/myOrder";
	}
	
	@RequestMapping(value = "/myOrder", method = RequestMethod.GET)
	public String addOrder(Model model, HttpSession session) {
		
		User u = (User) session.getAttribute("user");
		List<Orders> orders =  orderService.getOrder(u.getUid());
		model.addAttribute("orders", orders);
		
		return "front/myOrder";
	}
	@RequestMapping(value = "/myOrder", method = RequestMethod.POST)
	public String addOrderP(Model model, HttpSession session) {
		
		User u = (User) session.getAttribute("user");
		List<Orders> orders =  orderService.getOrder(u.getUid());
		model.addAttribute("orders", orders);
		
		return "front/myOrder";
	}
	
	@RequestMapping(value = "/status/{oid}", method = RequestMethod.GET)
	public String changeStatus(@PathVariable("oid") int oid){
		orderService.update(oid);
		
		return "forward:/myOrder";
	}
	
}
