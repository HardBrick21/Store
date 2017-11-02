package com.Hou.bookstore.pojo;

/*
*  @Author : Houlixuan
*  @Description :
*  @Date : Create in 17:30 2017/10/30
*  
 */


public class OrderItem {
	private int itid;
	private int bid;
	private int oid;
	private String bname;
	private int num;
	private double price;
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getItid() {
		return itid;
	}
	
	public void setItid(int itid) {
		this.itid = itid;
	}
	
	public int getBid() {
		return bid;
	}
	
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public int getOid() {
		return oid;
	}
	
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public String getBname() {
		return bname;
	}
	
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "OrderItem{" +
				"itid=" + itid +
				", bid=" + bid +
				", oid=" + oid +
				", bname='" + bname + '\'' +
				", num=" + num +
				'}';
	}
}
