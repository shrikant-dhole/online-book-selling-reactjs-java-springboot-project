package com.example.onlinebookshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinebookshop.Entity.Cart;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.User;
import com.example.onlinebookshop.Repository.CartRepository;
import com.example.onlinebookshop.Repository.ProductsRepository;
import com.example.onlinebookshop.Repository.UserRepository;
import com.example.onlinebookshop.exception.ProductNotFoundException;
import com.example.onlinebookshop.exception.UserNotFoundException;

@Service
@Transactional
public class CartServiceImpl implements ICartService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	ProductsRepository prodRepo;
	
	
	
	
	@Override
	public List<Cart> getAllBooks(User user) {
		// TODO Auto-generated method stub
		List<Cart> items=new ArrayList<>();
		items.addAll(cartRepo.getItemsByCustomer(user));

		return items;
	}

	@Override
	public String addItem( Integer productid,Integer user) {
		//cartRepo.addByIds(user.getId(), product.getProdId());
	Products products=prodRepo.findById(productid).orElseThrow(()-> new ProductNotFoundException("No products found"));
		//Cart cart=cartRepo.findByUserAndProduct(user, products);
		User users=userRepo.findById(user).orElseThrow(()-> new UserNotFoundException("No user found"));
	    Cart cart=new Cart();
		cart.setUser(users);
		cart.setProduct(products);
		cartRepo.save(cart);
		return "book added to cart successfully";
	
	}

	@Override
	public String removeItem(Integer id,Integer pid) {
	//	cartRepo.removeByIds(user.getId(), product.getProdId());
		
		cartRepo.removeByIds(id, pid);
		return "deleted to cart successfully";
	}


}
