package com.example.onlinebookshop.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.onlinebookshop.Entity.Orders;
import com.example.onlinebookshop.Entity.OrdersStatus;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{


	List<Orders> findByOrderStatusAndId(OrdersStatus status,Integer id);
	
	
	 Optional<Orders> findById(Integer id);
	 
	 

	 
	 
	 @Modifying
	 @Query("Update Orders o set o.user.id=null where user.id=:id")
	 int updateCustomerId(@Param(value ="id") int id);
	 
	 

	 @Modifying
	 @Query("Update Orders o set o.product.id=null where product.id=:id")
	 int updateProductId(@Param(value ="id") int id);
	 
	 
	
}
