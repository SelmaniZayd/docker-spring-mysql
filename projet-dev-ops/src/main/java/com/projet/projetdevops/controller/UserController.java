package com.projet.projetdevops.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.projetdevops.entity.User;
import com.projet.projetdevops.service.def.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String indexFile(Model model) {
		model.addAttribute("theDate", new java.util.Date());
		
		return "index";
	}
	
	@GetMapping("/list")
	public String getUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("usersList", users);
		return "users-list";
	}
	
	@GetMapping("/showAddUserForm")
	public String showAddForm(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return "user-form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user) {
		
		userService.addUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.isBourse());
		
		return "redirect:/users/list";
	}

}
