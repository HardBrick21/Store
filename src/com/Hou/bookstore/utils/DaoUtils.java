package com.Hou.bookstore.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtils {

	// 单例模式创建一个连接池对象

	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	public static ComboPooledDataSource getDataSource() {
		return ds;
	}

	public static Connection getConnection() throws SQLException {

		return ds.getConnection();

	}

}
