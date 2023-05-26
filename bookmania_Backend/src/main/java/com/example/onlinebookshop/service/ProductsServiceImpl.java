package com.example.onlinebookshop.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.onlinebookshop.Entity.Category;
import com.example.onlinebookshop.Entity.Orders;
import com.example.onlinebookshop.Entity.OrdersStatus;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.User;
import com.example.onlinebookshop.Repository.CartRepository;
import com.example.onlinebookshop.Repository.CategoryRepository;
import com.example.onlinebookshop.Repository.OrderRepository;
import com.example.onlinebookshop.Repository.ProductsRepository;
import com.example.onlinebookshop.Repository.UserRepository;
import com.example.onlinebookshop.dto.SellBook;
import com.example.onlinebookshop.exception.ProductNotFoundException;
import com.example.onlinebookshop.exception.UserNotFoundException;

@Service
@Transactional
public class ProductsServiceImpl implements IProductsService {

	

	@Autowired
	public ProductsRepository productrepo;
	
	@Autowired
	public CategoryRepository categoryrepo;
	
	@Autowired
	public OrderRepository orderRepo;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public CartRepository cartRepository;


	@Override
	public List<Products> getProduct() {
		
		List<Products> list=new ArrayList<>();
		productrepo.findAll().forEach(list::add);
		return list;
	}



	

	@Override
	public void deleteProduct(Integer id) {
		orderRepo.updateProductId(id);
		productrepo.deleteById(id);
	    
	}



	@Override
	public Products getById(Integer id) {
	
		return productrepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
	}

	@Override
	public List<Category> getallCategories() {
		// TODO Auto-generated method stub
		return categoryrepo.findAll();
	}

	@Override
	public List<Products> getProductsByCategory(Integer category) {
	
		List<Products> products=productrepo.findByCategory(category);
		
		return products;
	}

	@Override
	public String sellProduct(SellBook sellbook,Integer id) {
	
		User user= userRepository.findById(id).orElseThrow(()->new ProductNotFoundException("User not found"));
		Products prod =new Products(sellbook.getBookname(),sellbook.getPrice(),sellbook.getAuthor(),sellbook.getDesc(),sellbook.getImage());
	
		Optional<Category> cate=categoryrepo.findByCategory(sellbook.getCategory());
	
	
		if(cate.isPresent()) {

			prod.setCategory(cate.get());
		}else{
			throw new ProductNotFoundException("category not found");
		}
	
		prod.setAvailable(true);
		prod.setSeller(user);
		productrepo.save(prod);
		
		return "Successfully submitted";
	}
	
	

	@Override
	public String buyProduct(Integer userid, Integer prodid) {
		// TODO Auto-generated method stub
		User user= userRepository.findById(userid).orElseThrow(()->new ProductNotFoundException("User not found"));
		Orders order=new Orders();
		Products product= productrepo.findById(prodid).orElseThrow(()->new ProductNotFoundException("product not found"));
		
		order.setOrderStatus(OrdersStatus.PENDING);
		order.setProducts(product);
		order.setOrderTotal(product.getPrice());
		order.setDate(new Date(new Date().getDate()));
		order.setUser(user);
		product.setAvailable(false);
		productrepo.save(product);
		orderRepo.save(order);
		cartRepository.removeByIds(userid, prodid);
		
		return "Buy successful";
}

}
