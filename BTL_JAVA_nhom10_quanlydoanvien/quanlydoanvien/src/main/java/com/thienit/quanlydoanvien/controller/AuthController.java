package com.thienit.quanlydoanvien.controller;

import com.thienit.quanlydoanvien.entity.User;
import com.thienit.quanlydoanvien.repository.UserRepository;
import com.thienit.quanlydoanvien.service.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class AuthController {
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/do_create")
    public String doCreate(User user) {
        userService.save(user);
        return "redirect:/view";
    }
    
    @GetMapping("/list")
    public String listUser(Model model) {
    	model.addAttribute("users", userRepository.findAll());
    	return "users/list";
    }
    
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("user", userRepository.findById(id).orElse(null));
    	return "users/detail";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("user", userRepository.findById(id).orElse(null));
    	return "users/edit";
    }
    
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateEditForm(@ModelAttribute User user) {
    	Map<String, Object> response = new HashMap<>();
    	try {
    		userRepository.save(user);
            response.put("code", 200);
            response.put("message", "Cập nhật thành công!");
            return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("code", 500);
	        response.put("message", "Lỗi khi cập nhật người dùng: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
    
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("username", userDetails.getUsername());
        return "users/profile";
    }
}
