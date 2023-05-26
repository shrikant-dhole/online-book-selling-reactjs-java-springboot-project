package com.example.onlinebookshop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.onlinebookshop.Entity.Role;
import com.example.onlinebookshop.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

//	@Query("SELECT u from User u where u.email =?1")
//	User findByEmail(String email);
	
//	@Query("SELECT u from User u where u.email =?1 and u.password=?2")
//	User AuthenticateLogin(String email,String password);
	
	
//	
	
	Optional<User>  findByEmailAndPassword(String email,String password);
//	
	
	Optional<User> findByEmail(String email);
	
	
	List<User> findByRole(Role role); 
	
	
	 
	
}
