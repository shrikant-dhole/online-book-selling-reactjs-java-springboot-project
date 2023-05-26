package com.example.onlinebookshop.service;

import java.util.List;

import com.example.onlinebookshop.Entity.Category;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.dto.SellBook;

public interface IProductsService {
	
	 public List<Products> getProduct();
	
	
	 
	 public void deleteProduct(Integer id);
	 
	 public Products getById(Integer id);
	 
	 public List<Category> getallCategories();
	 
	 public String buyProduct(Integer userid, Integer prodid);
	 
	 
	 public List<Products> getProductsByCategory(Integer category );
	 
//	 public Products sellProduct();

	 String sellProduct(SellBook sellbook,Integer id );
	 
	 

}
