package com.example.onlinebookshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinebookshop.Entity.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
