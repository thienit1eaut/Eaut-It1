package com.thienit.StudentManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thienit.StudentManagement.models.User;
import com.thienit.StudentManagement.repository.UserRepository;

@Controller
public class BaseController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
	
	@GetMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "users/login";
	}
	
	@PostMapping(value = "/login")
	public String doLogin(@ModelAttribute User user, Model model) {
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "users/login";
        }
	}

}
