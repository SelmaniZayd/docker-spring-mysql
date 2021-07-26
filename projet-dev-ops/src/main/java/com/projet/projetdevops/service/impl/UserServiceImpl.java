package com.projet.projetdevops.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projet.projetdevops.entity.User;
import com.projet.projetdevops.repository.UserRepository;
import com.projet.projetdevops.service.def.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		return this.userRepository.findById(id);
	}

	@Override
	public User addUser(String firstName, String lastName, String email, int age, boolean bourse) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setAge(age);
		user.setBourse(bourse);
		
		this.userRepository.save(user);
		return user;
	}

	@Override
	public User updateUser(int id, String firstName, String lastName, String email, int age, boolean bourse) {
		Optional<User> oldUser = this.userRepository.findById(id);
		
		if(!oldUser.isPresent()) {
			return null;
		}
		
		User newUser = oldUser.get();
		newUser.setAge(age);
		newUser.setEmail(email);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setBourse(bourse);
		
		this.userRepository.save(newUser);
		
		return newUser;
	}

	@Override
	public void deleteUser(int id) {
		this.userRepository.deleteById(id);
		
	}

}
