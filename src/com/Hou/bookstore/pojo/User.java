package com.Hou.bookstore.pojo;

import java.sql.Date;

public class User {
	
	/**
	 * 
	 * uid username password 昵称 邮箱  性别 头像 角色  注册日期
	 * 
	 */

	private int uid;
	private String userName;
	private String passWord;
	private String nickName;
	private String email;
	private String gender;
	private String photo;
	private int role; // 1代表普通用户 2代表会员  100代表管理员
	private Date date; //注册日期
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", passWord=" + passWord + ", nickName=" + nickName
				+ ", email=" + email + ", gender=" + gender + ", photo=" + photo + ", role=" + role + ", date=" + date
				+ "]";
	}
	
	
	
	
}
