package com.example.onlinebookshop.Entity;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="orders")
public class Orders extends BaseEntity{

	@Enumerated(EnumType.STRING)
	@Column
	private OrdersStatus orderStatus;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;

	@OneToOne
	@JoinColumn(name="prod_id")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Products product;
	
	@Column
	private float orderTotal;
	
	@CreationTimestamp
	//@Generated(GenerationTime.ALWAYS)
	@Temporal(TemporalType.DATE)
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OrdersStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrdersStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Products getProducts() {
		return product;
	}

	public void setProducts(Products product) {
		this.product = product;
	}
	



	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Override
	public String toString() {
		return "Orders [orderStatus=" + orderStatus + ", user=" + user + "]";
	}

	public Orders() {
		super();
	}

	public Orders(OrdersStatus orderStatus, User user, Products product, float orderTotal, Date date) {
		super();
		this.orderStatus = orderStatus;
		this.user = user;
		this.product = product;
		this.orderTotal = orderTotal;
		this.date = date;
	}


	

	
	
}
