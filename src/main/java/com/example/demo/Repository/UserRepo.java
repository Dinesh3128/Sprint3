package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity1.Signup;
import com.example.demo.entity3.Login;

@Repository
public interface UserRepo extends JpaRepository<Login, Integer> {

	@Query(value =  "select * from Login where email =?" , nativeQuery = true)
	Login findByEmail(String email);

	Signup save(Signup newUser);


	
//	@Query(value = "delete from Student where email =?" , nativeQuery = true)
//	void deleteById(String email);

	
	
	
}
