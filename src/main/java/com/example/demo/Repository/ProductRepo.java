package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity1.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
	// You can define custom query methods here if needed
	@Query(value = "select * from Product where name =?", nativeQuery = true)
	Product findByName(String name);
}
