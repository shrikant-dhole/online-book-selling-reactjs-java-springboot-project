package com.example.onlinebookshop.dto;



public class SellBook {

	private int user;
	
	public int getUser() {
		return user;
	}


	public void setUser(int user) {
		this.user = user;
	}


	private String bookname;
	
	private String image;
	
	
	private float price;
	

	private String author;
	
	
	private String desc;


	private String category;	
	
	
	
	
	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;	
				}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public SellBook(String bookname, String image, float price, String author, String desc, String  category) {
		super();
		this.bookname = bookname;
		this.image = image;
		this.price = price;
		this.author = author;
		this.desc = desc;
		this.category = category;
	}


	public SellBook() {
		super();
	}



}
