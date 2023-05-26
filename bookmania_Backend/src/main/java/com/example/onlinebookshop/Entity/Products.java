package com.example.onlinebookshop.Entity;

import java.util.Arrays;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prodId;
	
	@Column(nullable=false)
	private String bookname;
	
	@Column(length=100000)
	private String image;
	
	@Column(nullable =false)
	private float price;
	
	@Column(nullable=false)
	private String author;
	
	@Column(length=200)
	private String desc;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="cat_id")
	private Category category;	
	
	@JsonIgnore
	private Boolean available;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="seller_id")
	private User seller;
	

	public User getSeller() {
		return seller;
	}


	public void setSeller(User seller) {
		this.seller = seller;
	}


	public Boolean getAvailable() {
		return available;
	}


	public Products(String bookname, float price, String author, String desc, Category category,
			User seller) {
		super();
		this.bookname = bookname;
		
		this.price = price;
		this.author = author;
		this.desc = desc;
		this.category = category;
		this.seller = seller;
	}


	public void setAvailable(Boolean available) {
		this.available = available;
	}


	public Products() {
		super();
	}


	public Products( String bookname, float price, String author, String desc, String image
			) {
		super();
		
		this.bookname = bookname;
		this.price = price;
		this.author = author;
		this.desc = desc;
	    this.image=image;
	}


	public Integer getProdId() {
		return prodId;
	}


	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}


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


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Products [bookname=" + bookname + ", image=" + image + ", price=" + price + ", author="
				+ author + ", desc=" + desc + ", category=" + category + "]";
	}
}
