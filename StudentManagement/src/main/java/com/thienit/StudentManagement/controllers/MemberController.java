package com.thienit.StudentManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thienit.StudentManagement.models.Member;
import com.thienit.StudentManagement.models.User;
import com.thienit.StudentManagement.repository.MemberRepository;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;



@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping
	public String listMember(Model model) {
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);
		
		return "members/view";
	}
	
	@GetMapping(value = "/insert")
	public String showAddForm(Model model) {
		model.addAttribute("member", new Member());
		
		return "members/add";
	}
	
	@PostMapping(value = "/insert")
	public String saveAddForm(@ModelAttribute("member") @Valid Member member, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
	        return "members/add";
	    }
		
		int gender = Integer.parseInt(member.getGender());
		
		if (gender == 0) {
			member.setGender("Nam");
		} else {
			member.setGender("Nữ");
		}
		
		String dateCode = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy"));
	    String generatedCode = "DV" + dateCode;
	    member.setCode(generatedCode);
	    
		memberRepository.save(member);
		
		return "redirect:/member";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("member", memberRepository.findById(id).orElse(null));
		
		return "members/edit";
	}
	
	@PostMapping("/update")
    public String updateEditForm(@ModelAttribute("member") @Valid Member member, BindingResult result) {
		
		if (result.hasErrors()) {
	        return "members/add";
	    }
		
		int gender = Integer.parseInt(member.getGender());
		
		if (gender == 0) {
			member.setGender("Nam");
		} else {
			member.setGender("Nữ");
		}
		
		memberRepository.save(member);
        return "redirect:/member";
    }
	
	@GetMapping("/delete/{id}")
    public String deleteItemData(@PathVariable("id") Long id) {
		memberRepository.deleteById(id);
        return "redirect:/member";
    }
	
	
}
