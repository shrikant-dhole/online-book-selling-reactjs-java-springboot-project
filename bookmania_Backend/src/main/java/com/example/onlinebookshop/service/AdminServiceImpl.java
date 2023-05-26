package com.example.onlinebookshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinebookshop.Entity.Orders;
import com.example.onlinebookshop.Entity.OrdersStatus;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.Role;
import com.example.onlinebookshop.Entity.User;
import com.example.onlinebookshop.Repository.OrderRepository;
import com.example.onlinebookshop.Repository.ProductsRepository;
import com.example.onlinebookshop.Repository.UserRepository;
import com.example.onlinebookshop.exception.OrderCompletedException;
import com.example.onlinebookshop.exception.UserNotFoundException;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService{

	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProductsRepository productRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	
	@Override
	public List<User> getAllCustomer() {
		
		return userRepo.findByRole(Role.CUSTOMER);
	}

	@Override
	public List<Products> getAllProducts() {
		
		return productRepo.findAll();
	}
	
	

	@Override
	public User getAdminById(Integer id) {
		User admin=userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("No user found"));
		if(admin.getRole().equals(Role.ADMIN))
		return admin;
		else
			throw new UserNotFoundException("No admin Found");
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}
	
	@Override
	public String orderCompleted(Integer orderid ) {
		Orders order=orderRepo.findById(orderid)
		.orElseThrow(()-> new UserNotFoundException("No order found"));
		if(order.getOrderStatus().equals(OrdersStatus.PENDING))
		{
	       
			order.setOrderStatus(OrdersStatus.COMPLETED);
		
			orderRepo.save(order);
			Products product =order.getProduct();
			product.setAvailable(false);
			productRepo.save(product);
			
			return "order completed";
		}
		throw new OrderCompletedException("Order already completed");
	}

}
