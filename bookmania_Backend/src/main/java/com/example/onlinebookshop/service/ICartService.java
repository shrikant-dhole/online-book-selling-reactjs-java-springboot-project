package com.example.onlinebookshop.service;

import java.util.List;

import com.example.onlinebookshop.Entity.Cart;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.User;

public interface ICartService {

	public List<Cart> getAllBooks(User user);
	
	public String addItem(Integer product,Integer user);
	
	public String removeItem(Integer id , Integer pid);
	
	
	
	
	
}
