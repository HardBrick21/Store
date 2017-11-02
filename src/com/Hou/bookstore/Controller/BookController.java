package com.Hou.bookstore.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.Hou.bookstore.pojo.Book;
import com.Hou.bookstore.pojo.BookType;
import com.Hou.bookstore.service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/book")
public class BookController {
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	
	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public String addBook(Model model){
		//获取图书类型集合
		List<BookType> types = bookService.getAllBookType();
		//转发数据到addBook.jap
		model.addAttribute("types",types);
		return "admin/book/addBook";
	}
	
	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public String addBook(Book book, MultipartFile picfile) throws IllegalStateException, IOException{
		
		
		if (!picfile.isEmpty()) {
			
		String name = picfile.getOriginalFilename();
		String picname = System.currentTimeMillis()+name.substring(name.lastIndexOf("."));
		System.out.println(picname);
		String basepath = "e:\\icon\\";
		File file = new File(basepath+picname);
		
		//将传递来的文件写入到文件中
		
		picfile.transferTo(file);
		book.setIcon("/icon/" + picname);
		
		//写入到数据库
		bookService.addBook(book);
		
		}
		
		System.out.println(book);
		
		return "forward:/book/bookList";
		
	}
	@RequestMapping(value="/bookList", method=RequestMethod.GET)
	public String bookList(Model model){
		
		//获取所有图书
		List<Book> books = bookService.getBooks();
		model.addAttribute("books", books);
		return "admin/book/bookList";
	}
	@RequestMapping(value="/bookList", method=RequestMethod.POST)
	public String bookList1(Model model){
		
		//获取所有图书
		List<Book> books = bookService.getBooks();
		model.addAttribute("books", books);
		return "admin/book/bookList";
	}
	
	@RequestMapping(value="/bookType", method=RequestMethod.GET)
	public String bookType(Model model){
		
		//获取所有图书的类型
		
		List<BookType> types = bookService.getAllBookType();
		model.addAttribute("types", types);
		
		
		return "admin/book/bookType";
	}
	
	@RequestMapping(value = "/addbooktype", method=RequestMethod.GET)
	public String addBookType(BookType type, Model model){
		
		String result = bookService.addBookType(type);
		if (!"类型插入成功".equals(result)) {
			model.addAttribute("msg", result);
		}
		return "forward:/book/bookType"; //要转发到 /booktype上 而不是jsp上
		
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchBook(Model model, HttpServletRequest request, HttpServletResponse response){
		
		
		String bname = request.getParameter("search");
		List<Book> book =  bookService.searchBook(bname);
//		System.out.println("result :" + book.toString());
		model.addAttribute("searchReault", book);
		return "front/searchResult";
	}

}
