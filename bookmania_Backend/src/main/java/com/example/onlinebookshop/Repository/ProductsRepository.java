package com.example.onlinebookshop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.onlinebookshop.Entity.Category;
import com.example.onlinebookshop.Entity.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer>{

//	@Query(value="select p.bookname, p.author,p.price,p.category from Products p",nativeQuery = true)
//	public List<Products> getBooks();
//	
	@Query("from Products where lower(bookname) like :search")
	public List<Products> searchBooks(@Param("search") String search);

	@Query("select p from Products p where p.category.catid=:category")
	public List<Products> findByCategory(Integer category);
//
//	@Query(value= "select c,d from Products as c, Category as d where c.pid=c.pid")
//	int findById(int pid);
	 
}
