package com.Hou.bookstore.pojo;

/*
*  @Author : Houlixuan
*  @Description :
*  @Date : Create in 17:28 2017/10/30
*  
 */


public class Orders {
	private int oid;
	private int ono;
	private int uid;
	private String address;
	private String userName;
	private int phone;
	private String price;
	private String status;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String satus) {
		this.status = satus;
	}
	
	
	public int getOid() {
		return oid;
	}
	
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public int getOno() {
		return ono;
	}
	
	public void setOno(int ono) {
		this.ono = ono;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Orders{" +
				"oid=" + oid +
				", ono=" + ono +
				", uid=" + uid +
				", address='" + address + '\'' +
				", userName='" + userName + '\'' +
				", phone=" + phone +
				", price=" + price +
				", satus='" + status + '\'' +
				'}';
	}
}
