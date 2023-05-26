package com.example.onlinebookshop.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="cart")
public class Cart extends BaseEntity {

	
	public Cart() {
		super();
	}

	public Cart(User user, Products product) {
		super();
		this.user = user;
		this.product = product;
	}

	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="prod_id")
	private Products product;
	
	
}
