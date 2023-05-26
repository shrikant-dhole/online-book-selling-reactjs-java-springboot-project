package com.example.onlinebookshop.Repository;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.onlinebookshop.Entity.Cart;
import com.example.onlinebookshop.Entity.Products;
import com.example.onlinebookshop.Entity.User;



@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {


	@Query("from Cart where user is :customer")
	public List<Cart> getItemsByCustomer(@Param("customer") User user);
	
	@Transactional
	@Modifying
	@Query(value = "Insert into cart(user_id,prod_id) values(?1, ?2)", nativeQuery = true)
	public Cart findByUserAndProduct(Integer userId, Integer prodId);
	
	@Query("from Cart where book is :book")
	public List<Cart> getItemsByBook(@Param("book") Products book);

	@Transactional
	@Modifying
	@Query(value = "Insert into cart(user_id,prod_id) values(?1, ?2)", nativeQuery = true)
	public int addByIds(Integer userId, Integer prodId);
	
	
	@Transactional
	@Modifying
	@Query(value = "delete from cart where user_id = ?1 and prod_id = ?2", nativeQuery = true)
	public int removeByIds(Integer userId, Integer prodId);


	
	
}
