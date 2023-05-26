package com.example.onlinebookshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.onlinebookshop.Entity.Orders;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.User;
import com.example.onlinebookshop.service.IAdminService;
import com.example.onlinebookshop.service.IProductsService;
import com.example.onlinebookshop.service.IUserService;


import lombok.extern.slf4j.Slf4j;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/bookshop/admin")
@Slf4j
public class AdminController {
	
	Logger log= LoggerFactory.getLogger(AdminController.class);
	
	
	@Autowired
	IAdminService adminService;
	
	@Autowired
	IProductsService productService;
	
	@Autowired
	IUserService custService;
	

	
	
	@GetMapping("/getallbooks")
	public ResponseEntity<?> getAllBooks(){
		List<Products> prodList=adminService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(prodList);
	}
	
	@GetMapping("/getallcustomer")
	public ResponseEntity<?> getAllCustomerFromAdmin(){
		List<User> userList=adminService.getAllCustomer();
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}

	@GetMapping("/getallorders")
	public ResponseEntity<?> getAllOrders(){
		List<Orders> orderList=adminService.getAllOrders();
		return ResponseEntity.status(HttpStatus.OK).body(orderList);
	}
		
	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id)
	{
		 
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product is successfully deleted");
	}
		
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id)
	{
		custService.deleteCustomer(id);
		return ResponseEntity.status(HttpStatus.OK).body("Customer Account is successfully deleted");
	}
	@GetMapping("/changeorderstatus/{oid}")
	public ResponseEntity<?> changeOrderStatus(@PathVariable Integer oid ){
	      
		return ResponseEntity.status(HttpStatus.OK).body(adminService.orderCompleted(oid));
	}
}

