package com.Hou.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Hou.bookstore.Dao.BookDao;
import com.Hou.bookstore.pojo.Book;
import com.Hou.bookstore.pojo.BookType;

@Service("bookService")
public class BookService {
	
	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;
	public String addBookType(BookType type){
		
		//检查类型是否存在    ---不重复再插入
		
		BookType bt = bookDao.queryBookType(type.getTname());
		if (bt != null) {
			
			return "类型名已经存在";
			
		}
		bookDao.insert(type);
		
		return "类型插入成功";
	}
	
	public List<BookType> getAllBookType(){
		
		return bookDao.queryBookType();
	}
	
	public void addBook(Book book){
		bookDao.insert(book);
	}
	
	public List<Book> getBooks(){
		return bookDao.queryBooks();
	}
	
	public Book getBook(int bid){
		return bookDao.queryBook(bid);
	}
	
	public List<Book> searchBook(String bname){
		return bookDao.searchBook(bname);
	}

}
