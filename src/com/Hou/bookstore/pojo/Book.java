package com.Hou.bookstore.pojo;

import java.util.Date;

public class Book {
	/**
	 *  bid int primary key auto_increment,
 		bname varchar(20) not null,
 		author varchar(20) not null,
 		tid int,
 		press varchar(20),
 		price double,
 		count int,
 		date date,
 		description text,
 		icon varchar(50),
 		outcount int,
 		foreign key(tid) references booktype(tid)
	 */
	
	private int bid;
	private String bname;
	private String author;
	private int tid;
	private String press;
	private String tname;
	private double price;
	private int count;
	private Date date;
	private String description;
	private String icon;
	private int outcount;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getOutcount() {
		return outcount;
	}
	public void setOutcount(int outcount) {
		this.outcount = outcount;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author + ", tid=" + tid + ", press=" + press
				+ ", tname=" + tname + ", price=" + price + ", count=" + count + ", date=" + date + ", description="
				+ description + ", icon=" + icon + ", outcount=" + outcount + "]";
	}
	
	
}
