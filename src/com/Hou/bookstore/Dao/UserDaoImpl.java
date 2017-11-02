package com.Hou.bookstore.Dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.Hou.bookstore.pojo.BookType;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Hou.bookstore.pojo.User;
import com.Hou.bookstore.utils.DaoUtils;

@Repository("userDao")

public class UserDaoImpl implements UserDao {

	public void insert1(User user) {

		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());

		String sql = "insert into users value(null,?,?,?,?,?,?,?,?)";

		try {
			qr.update(sql, user.getUserName(), user.getPassWord(), user.getNickName(), user.getEmail(),
					user.getGender(), user.getPhoto(), user.getRole(), user.getDate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub

		try {

			Connection conn = DaoUtils.getConnection();
			String sql = "insert into users value(null,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassWord());
			pst.setString(3, user.getNickName());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getGender());
			pst.setString(6, user.getPhoto());
			pst.setInt(7, user.getRole());
			pst.setDate(8, user.getDate());

			pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// 如果有异常 我们继续抛它
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean queryUser(String name) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			conn = DaoUtils.getConnection();

			String sql = "select * from users where userName=?";

			pst = conn.prepareStatement(sql);

			pst.setString(1, name);

			rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public User queryUser(String name, String password) {
		// TODO Auto-generated method stub

		try {

			Connection conn = DaoUtils.getConnection();
			String sql = "select * from users where userName=? and passWord=?";

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, name);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				int uid = rs.getInt("uid");
				String userName = rs.getString("userName");
				String passWord = rs.getString("passWord");
				String nickName = rs.getString("nickName");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				String photo = rs.getString("photo");
				int role = rs.getInt("role");
				Date date = rs.getDate("date");

				User user = new User();
				user.setUid(uid);
				user.setUserName(userName);
				user.setNickName(nickName);
				user.setEmail(email);
				user.setGender(gender);
				user.setPassWord(passWord);
				user.setDate(date);
				user.setRole(role);
				user.setPhoto(photo);

				return user;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new RuntimeException(e);
		}

		return null;
	}
	
	@Override
	public User queryUser(int uid) {
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "select * from users where uid=?";
		try {
			// BeanListHandler 吧resultset结果集转换成list对象 list元素类型是 booktype
			return qr.query(sql, new BeanHandler<User>(User.class), uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void alertInfor(int uid, String nickName) {
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		String sql = "UPDATE users SET nickName=? WHERE uid=?";
		try {
			// BeanListHandler 吧resultset结果集转换成list对象 list元素类型是 booktype
			qr.update(sql, nickName, uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
