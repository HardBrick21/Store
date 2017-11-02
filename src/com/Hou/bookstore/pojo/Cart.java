package com.Hou.bookstore.pojo;

/*
*  @Author : Houlixuan
*  @Description :
*  @Date : Create in 8:50 2017/10/27
*  
 */


public class Cart {
	
	//cart 数据表字段
	private int cid;
	private int bid;
	private int num;
	private int uid;
	//关联查询出图书信息
	private String bname;
	private double price;
	private String press;
	private String icon;
	
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public int getBid() {
		return bid;
	}
	
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getBname() {
		return bname;
	}
	
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getPress() {
		return press;
	}
	
	public void setPress(String press) {
		this.press = press;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@Override
	public String toString() {
		return "Cart{" +
				"cid=" + cid +
				", bid=" + bid +
				", num=" + num +
				", uid=" + uid +
				", bname='" + bname + '\'' +
				", price=" + price +
				", press='" + press + '\'' +
				", icon='" + icon + '\'' +
				'}';
	}
}
