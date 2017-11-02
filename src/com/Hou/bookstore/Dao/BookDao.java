package com.Hou.bookstore.Dao;

import java.util.List;

import com.Hou.bookstore.pojo.Book;
import com.Hou.bookstore.pojo.BookType;

public interface BookDao {
	
	/**
	 * 
	 * 插入图书
	 */
	void insert(Book book);
	
	/**
	 * 
	 * 插入图书类型
	 * @param type
	 */
	void insert(BookType type);
	
	/**
	 * 
	 *查询所有图书类型 
	 */
	List<BookType> queryBookType();
	
	/**
	 * 
	 * 根据类型名查询类型对象
	 * @param tname
	 * @return  查询不到返回null
	 */
	BookType queryBookType(String tname);
	
	/**
	 * 查询所有图书 
	 * @return
	 */
	List<Book> queryBooks();
	
	/**
	 * 
	 * 根据Bid查询图书
	 * @param bid
	 * @return
	 */
	Book queryBook(int bid);
	
	public List<Book> searchBook(String bname);
	
}
