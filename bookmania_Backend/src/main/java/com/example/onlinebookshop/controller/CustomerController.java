package com.example.onlinebookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.example.onlinebookshop.Entity.Cart;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.User;
import com.example.onlinebookshop.Repository.ProductsRepository;
import com.example.onlinebookshop.Repository.UserRepository;
import com.example.onlinebookshop.dto.SellBook;
import com.example.onlinebookshop.dto.UpdatePassword;
import com.example.onlinebookshop.service.IAdminService;
import com.example.onlinebookshop.service.ICartService;
import com.example.onlinebookshop.service.IProductsService;
import com.example.onlinebookshop.service.IUserService;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/bookshop/customer")
@Slf4j
public class CustomerController {
	
 Logger log = LoggerFactory.
		getLogger(CustomerController.class);
 
 @Autowired
 IUserService custService;
 
 @Autowired
 IAdminService adminService;
 
 @Autowired
 IProductsService productsService;
 
@Autowired
ICartService cartService;
 
 @Autowired
 private JavaMailSender javasender;
 
 @GetMapping("/{id}")
	public ResponseEntity<?> getCustomerdetails(@PathVariable int id)
	{
		log.info("customer ID::"+id);
		User cust=custService.getUserById(id);
			return ResponseEntity.status(HttpStatus.OK).body(cust);
	}
 
 @PostMapping("/register")
	public ResponseEntity<?> createNewCustomerAccount(@RequestBody @Valid User cust)
	{
		SimpleMailMessage msg = new SimpleMailMessage();
		User customer=custService.addNewCustomer(cust);
		log.info("Customer details :: "+customer);
		//c.f. implements future and completion stage
		//two methods in c.f. runAsync and supplyAsync
		//runAsync takes runnable object
		//runAsyn-->Returns a new CompletableFuture that is asynchronously completed by a task running in the ForkJoinPool.commonPool() after it runs the given action.
		CompletableFuture<Void> future=CompletableFuture.runAsync(()->
		{
		msg.setTo(customer.getEmail());
		msg.setSubject("Account created Succeffully");
		msg.setText("Dear "+customer.getFirstName()+" "+customer.getLastName() +", \n Your account is Successfully created. Welcome to the BookMania."+"\n email :"+ customer.getEmail()+"\n password :"+customer.getPassword() + "\n\nRegards\n BookMania");
		javasender.send(msg);
		log.info("msg "+msg);
		});
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
 
	
	@PostMapping("/updatepassword")
	public ResponseEntity<?> updatePassword(@RequestBody UpdatePassword updatepassword)
	{
		SimpleMailMessage msg = new SimpleMailMessage();
		User cust=custService.updatePassword(updatepassword);
		msg.setTo(cust.getEmail());
		msg.setSubject("Retrieved Password");
		msg.setText("Dear "+cust.getFirstName()+" "+cust.getLastName() +", \n Your password is Updated.\n\nRegards\n BookMania");
		javasender.send(msg);
		return ResponseEntity.status(HttpStatus.OK).body(cust);
	}
	

	
	@GetMapping("/orders/{id}")
	public ResponseEntity<?> getAllOrders(@PathVariable(name="id") int customerId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(custService.getAllOrders(customerId));
	}
	
	@PostMapping("/{id}/sell")
	public ResponseEntity<?> getBook(@RequestBody @Valid SellBook sellBook,@PathVariable Integer id )
	{
		return ResponseEntity.status(HttpStatus.OK).body(productsService.sellProduct(sellBook,id));
	}

	@PostMapping("/{userid}/addtocart/{prodid}")
	public ResponseEntity<?> addToCart(@PathVariable Integer prodid,@PathVariable Integer userid)
	{
		return ResponseEntity.status(HttpStatus.OK).body(cartService.addItem(prodid, userid));
	}
	
;
	@GetMapping("/{id}/cart")
	public ResponseEntity<?> getAllBooks(@PathVariable Integer id){
		User user = custService.getUserById(id);
		List<Cart> prodList= cartService.getAllBooks(user);
		return ResponseEntity.status(HttpStatus.OK).body(prodList);
	}
	@GetMapping("/getallbooks")
	public ResponseEntity<?> getAllBooks(){
		List<Products> prodList=adminService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(prodList);
	}
	
	
	@DeleteMapping("/{userid}/cart/{pid}/deletefromcart")
	public ResponseEntity<?> deleteBook(@PathVariable int userid ,@PathVariable int pid)
	{
	return ResponseEntity.status(HttpStatus.OK).body(cartService.removeItem(userid,pid));
	}
	
	
	@PostMapping("/{userid}/buy/{prodid}")
	public ResponseEntity<?> buyBook(@PathVariable (name="userid") Integer userid,@PathVariable (name="prodid") Integer prodid)
	{
		return ResponseEntity.status(HttpStatus.OK).body(productsService.buyProduct(userid, prodid));
	}
	
	
	@DeleteMapping("/cancelorder/{oid}")
	public ResponseEntity<?> cancelOrder(@PathVariable int oid )
	{
	return ResponseEntity.status(HttpStatus.OK).body(custService.cancelOrder(oid));
	}
	
	@PostMapping("/{pid}/payment")
	public String createOrder(@PathVariable int pid ,@RequestBody Map<String ,Object> data) throws Exception {
		Products product = productsService.getById(pid);
		System.out.println(data);
		System.out.println("hey order creating!!!!");
		
		var client=new RazorpayClient("rzp_test_Hl5GAeKPrC71Or", "gZ6GeKg4qYDEbkWvzUvD7Nt2");
			
		
		JSONObject options = new JSONObject();
		options.put("amount", product.getPrice()+50);
		options.put("currency", "INR");
	 	options.put("receipt", "txn_123456");
		//creating an order
		com.razorpay.Order order = client.Orders.create(options);
		System.out.println(order);
		
		return order.toString();
	}
}
	

