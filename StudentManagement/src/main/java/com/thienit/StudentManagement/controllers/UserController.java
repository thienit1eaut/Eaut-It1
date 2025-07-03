package com.thienit.StudentManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thienit.StudentManagement.models.User;
import com.thienit.StudentManagement.repository.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public String listUsers(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		
		return "users/view";
	}
	
	@GetMapping(value = "/register")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		
		return "users/register";
	}
	
	@PostMapping(value = "/register")
	public String saveForm(@ModelAttribute User user, Model model) {
		// user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		model.addAttribute("name", user.getUsername());
		
		return "redirect:/login";
	}
}
