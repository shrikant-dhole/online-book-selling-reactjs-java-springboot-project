package com.example.onlinebookshop.service;

import java.util.List;

import com.example.onlinebookshop.Entity.Orders;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.User;

public interface IAdminService {

	List<User> getAllCustomer();
	
	List<Products> getAllProducts();
	
	List<Orders> getAllOrders();
	
	public User getAdminById(Integer id);
	
	public String orderCompleted(Integer orderid);
	
	
}
