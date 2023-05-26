package com.example.onlinebookshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinebookshop.Entity.Address;
import com.example.onlinebookshop.Entity.Orders;
import com.example.onlinebookshop.Entity.OrdersStatus;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.Role;
import com.example.onlinebookshop.Entity.User;
import com.example.onlinebookshop.Repository.AddressRepository;
import com.example.onlinebookshop.Repository.OrderRepository;
import com.example.onlinebookshop.Repository.ProductsRepository;
import com.example.onlinebookshop.Repository.UserRepository;
import com.example.onlinebookshop.dto.UpdatePassword;
import com.example.onlinebookshop.exception.OrderCompletedException;
import com.example.onlinebookshop.exception.UserNotFoundException;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductsRepository productRepo;
	
	@Override
	public User getUserById(Integer userId) {
		User customer=userRepo.findById(userId).orElseThrow(()-> new UserNotFoundException("No user found"));
		if(customer.getRole().equals(Role.CUSTOMER))
		return customer;
		else
			throw new UserNotFoundException("No customer Found");
	}

	@Override
	public User authenticateCustomerAdmin(String email, String password) {
		
	return userRepo.findByEmailAndPassword(email, password)
	.orElseThrow(()-> new UserNotFoundException("No user found"));
	}

	@Override
	public User addNewCustomer(User customer) {
		
		Address address=addressRepo.save(customer.getAddress());
		User cust=new User(customer.getEmail(),customer.getFirstName(),customer.getLastName(),customer.getPassword(),customer.getContactNo(),Role.CUSTOMER);
		cust.setAddress(address);
		return userRepo.save(cust);
	}

	@Override
	public void deleteCustomer(Integer id) {
		orderRepo.updateCustomerId(id);
		userRepo.deleteById(id);

	}

	@Override
	public User updateCustomer(User customer) {
		User cust=userRepo.findById(customer.getId())
		.orElseThrow(()-> new UserNotFoundException("No user found"));
		customer.getAddress().setId(cust.getAddress().getId());
		addressRepo.save(customer.getAddress());
		return userRepo.save(customer);
	}



	@Override
	public User updatePassword(UpdatePassword updatePassword) {
		User customer=authenticateCustomerAdmin(updatePassword.getUserEmail(), updatePassword.getOldPassword());
		customer.setPassword(updatePassword.getNewPassword());

		return userRepo.save(customer);
	}

	@Override
	public List<Orders> getOrders(OrdersStatus status, Integer id) {
		
		return orderRepo.findByOrderStatusAndId(status, id);
	}

	@Override
	public Optional<Orders> getAllOrders(Integer id) {
	
		return orderRepo.findById(id);
	}

	@Override
	public String cancelOrder(Integer oid) {
		Orders order=orderRepo.findById(oid)
				.orElseThrow(()-> new UserNotFoundException("No user found"));
		if(order.getOrderStatus().equals(OrdersStatus.PENDING)) {
			Products products = order.getProduct();
			products.setAvailable(true);
			productRepo.save(products);
			orderRepo.deleteById(oid);
		return "Order Cancelled successfully";
			
		}
		
		return "Sorry Order is completed You cannot cancel order now Please contact us";
	
	}

	
	
	



}
