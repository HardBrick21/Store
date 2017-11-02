package com.Hou.bookstore.Controller;

import com.Hou.bookstore.pojo.Cart;
import com.Hou.bookstore.pojo.User;
import com.Hou.bookstore.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/buy")
public class BuyController {
	
	@Autowired
	@Qualifier("buyService")
	private BuyService buyService;
	
	@RequestMapping("/cart")
	public String cart(Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		List<Cart> carts = buyService.getCarts(user.getUid());
		model.addAttribute("carts", carts);
		return "front/cart";
	}
	
	@RequestMapping("/addcart/{bid}")
	public String addCart(@PathVariable("bid") int bid, HttpSession session) {
		//如果不想直接转发到jsp而是想转发一串请求url上则用forword
		Cart cart = new Cart();
		cart.setBid(bid);
		User user = (User) session.getAttribute("user");
		cart.setUid(user.getUid());
		//添加记录到数据库
		
		buyService.addCart(cart);
		return "forward:/buy/cart";
	}
	
}
