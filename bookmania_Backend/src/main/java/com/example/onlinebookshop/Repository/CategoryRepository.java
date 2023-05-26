package com.example.onlinebookshop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.onlinebookshop.Entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
//
//	@Query("select c.category from Category c")
//	public List<Category> getProducts();
//	
//	
//	@Query(value="select c.Category from Category c",nativeQuery = true)
	public Optional<Category> findByCategory(String string);
	
	
}
