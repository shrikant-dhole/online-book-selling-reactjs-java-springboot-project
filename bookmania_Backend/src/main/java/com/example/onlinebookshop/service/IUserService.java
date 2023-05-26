package com.example.onlinebookshop.service;

import java.util.List;
import java.util.Optional;

import com.example.onlinebookshop.Entity.Orders;
import com.example.onlinebookshop.Entity.OrdersStatus;
import com.example.onlinebookshop.Entity.User;
import com.example.onlinebookshop.dto.UpdatePassword;

public interface IUserService {
	
	//public List<User> getAllUser();
	
	public User getUserById(Integer userId);
	
	public User authenticateCustomerAdmin(String email,String password);
	
	public User addNewCustomer(User customer);
	
	public void deleteCustomer(Integer id);
	
	public User updateCustomer(User customer);
	
//	public User getCustomerByEmail(String email);
	
	public User updatePassword(UpdatePassword updatePassword);
	
	public List<Orders> getOrders(OrdersStatus status,Integer id);
	

	public Optional<Orders> getAllOrders(Integer id);
	
	
	public String cancelOrder(Integer oid);

	
	

	
	

}
