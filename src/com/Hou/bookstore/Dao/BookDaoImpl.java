package com.Hou.bookstore.Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.Hou.bookstore.pojo.Book;
import com.Hou.bookstore.pojo.BookType;
import com.Hou.bookstore.utils.DaoUtils;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
	
	@Override
	public void insert(Book book) {
		// TODO Auto-generated method stub
		// 连接 关闭 都由该方法操作
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "insert into books value(null,?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, book.getBname(), book.getAuthor(), book.getTid(), book.getPress(), book.getPrice(),
					book.getCount(), null, book.getDescription(), book.getIcon(), book.getOutcount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void insert(BookType type) {
		
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "insert into booktype value(null, ?)";
		
		try {
			qr.update(sql, type.getTname());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
	@Override
	public List<BookType> queryBookType() {
		// TODO Auto-generated method stub
		
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "select * from booktype;";
		
		try {
			// BeanListHandler 吧resultset结果集转换成list对象 list元素类型是 booktype
			return qr.query(sql, new BeanListHandler<BookType>(BookType.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public BookType queryBookType(String tname) {
		// TODO Auto-generated method stub
		
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "select * from booktype where tname=?;";
		
		try {
			// BeanListHandler 吧resultset结果集转换成list对象 list元素类型是 booktype
			return qr.query(sql, new BeanHandler<BookType>(BookType.class), tname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<Book> queryBooks() {
		// TODO Auto-generated method stub
		
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "select * from books;";
		
		try {
			// BeanListHandler 吧resultset结果集转换成list对象 list元素类型是 booktype
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Book queryBook(int bid) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "select * from books where bid=?;";
		
		try {
			// BeanListHandler 吧resultset结果集转换成list对象 list元素类型是 booktype
			return qr.query(sql, new BeanHandler<Book>(Book.class), bid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Book> searchBook(String bname) {
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "SELECT * FROM books WHERE bname LIKE '%' ? '%';";
		try {
			// BeanListHandler 吧resultset结果集转换成list对象 list元素类型是 booktype
			//System.out.println(sql);
			return qr.query(sql, new BeanListHandler<Book>(Book.class), bname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
