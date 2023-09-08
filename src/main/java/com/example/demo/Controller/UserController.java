package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.UserService;
import com.example.demo.entity3.Login;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public Login login(@RequestHeader String email ,
			@RequestHeader String password) {
		
		return userService.login(email, password); 
	}
	
}
