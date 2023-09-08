package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;
import com.example.demo.entity1.Signup;
import com.example.demo.entity3.Login;

@Service
public class ServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public Login login(String email, String password) {
		Login s = userRepo.findByEmail(email);
		 
		 if(s!=null) {
			 if(s.getPassword().equals(password)) {
				 return s;
			 }else {
				throw new ResourceNotFoundException();
			}
		 }else {
			 throw new ResourceNotFoundException();
		 }

	}
	public Signup signup(String fullName, String email, String password) {
		// Check if the email is already registered
		if (userRepo.findByEmail(email) != null) {
			throw new ResourceNotFoundException();
		}

		// Create a new user
		Signup newUser = new Signup();
		newUser.setFullName(fullName);
		newUser.setEmail(email);
		newUser.setPassword(password); // Store the plain-text password

		// Save the user to the database
		return userRepo.save(newUser);


}

/*
 * @Override public User addUser(User user) { // TODO Auto-generated method stub
 * return userRepo.save(user); }
 * 
 * @Override public User updatedb(String email, User user) { // TODO
 * Auto-generated method stub
 * 
 * User s1 = userRepo.findByEmail(email);
 * 
 * if(s1!=null) { s1.setFirstName(user.getFirstName()); // old to new set
 * s1.setLastName(user.getLastName()); s1.setPassword(user.getPassword());
 * return userRepo.save(s1); } else { throw new ResourceNotFoundException(); } }
 * 
 * @Override public void Delete(String email) { // TODO Auto-generated method
 * stub
 * 
 * User s2 = userRepo.findByEmail(email);
 * 
 * if(s2!=null) { userRepo.delete(s2); } else { throw new
 * ResourceNotFoundException(); } }
 */

}
