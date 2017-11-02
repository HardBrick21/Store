package com.Hou.bookstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MangerController {
	
	@RequestMapping(value="/manger")
	public String manger(){
		///WEN-INF/jsp/admin/manger.jsp
		return "admin/manger";
	}
}
