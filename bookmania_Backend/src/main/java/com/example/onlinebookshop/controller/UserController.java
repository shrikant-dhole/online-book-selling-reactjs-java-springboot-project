package com.example.onlinebookshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinebookshop.Entity.Cart;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.User;
import com.example.onlinebookshop.dto.AuthenticateUser;
import com.example.onlinebookshop.service.ICartService;
import com.example.onlinebookshop.service.IProductsService;
import com.example.onlinebookshop.service.IUserService;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/bookshop/user")
@Slf4j
public class UserController {

	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService cust_service;
	
	@Autowired
	IProductsService  productsService;
	
	
	
	@Autowired
	private JavaMailSender javasender;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateCustomer(@RequestBody @Valid AuthenticateUser customer)
	{
		log.info(customer.getUserEmail()+"::"+customer.getPassword());
		User cust=cust_service.authenticateCustomerAdmin(customer.getUserEmail(),customer.getPassword());
			return ResponseEntity.status(HttpStatus.OK).body(cust);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session)
	{
		session.invalidate();
		log.info("Customer Logout");
		return ResponseEntity.status(HttpStatus.OK).body("Customer successfully logout");
	}
	
	@GetMapping("/getallCategories")
	public ResponseEntity<?> getAllCategories()
	{
		return ResponseEntity.status(HttpStatus.OK).body(productsService.getallCategories());
	}
	
	@GetMapping("/getproductsbycategory/{id}")
	public ResponseEntity<?> getProductsByCategories(@PathVariable Integer id)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(productsService.getProductsByCategory(id));
	}
	
}
