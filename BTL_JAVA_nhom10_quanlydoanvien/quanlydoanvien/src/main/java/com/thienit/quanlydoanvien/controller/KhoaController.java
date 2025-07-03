package com.thienit.quanlydoanvien.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thienit.quanlydoanvien.entity.DoanVien;
import com.thienit.quanlydoanvien.entity.Khoa;
import com.thienit.quanlydoanvien.repository.KhoaRepository;

@Controller
@RequestMapping("/khoa")
public class KhoaController {
	
	@Autowired
	private KhoaRepository khoaRepository;
	
	@GetMapping("/list")
	public String listDoanVien(Model model) {
    	model.addAttribute("khoas", khoaRepository.findAll());
    	return "khoa/list";
    }
	
	@GetMapping("/create")
    public String registerForm(Model model) {
        model.addAttribute("khoa", new Khoa());
        
        return "khoa/add";
    }
	
	@PostMapping(value = "/insert")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> saveAddForm(@ModelAttribute Khoa khoa, Model model) {
		Map<String, Object> response = new HashMap<>();
		try {
		    khoa.setMakh(taoMaKhoa(khoa.getTenkh()));
		    khoaRepository.save(khoa);
			response.put("code", 200);
            response.put("message", "Thêm mới thành công!");
            response.put("redirect", "/khoa/list");
            return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("code", 500);
	        response.put("message", "Lỗi khi cập nhật người dùng: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	private String taoMaKhoa(String tenKhoa) {
		if (tenKhoa == null || tenKhoa.trim().isEmpty()) {
            return "KHNULL"; // Hoặc throw exception
        }
		
		String[] words = tenKhoa.trim().split("\\s+");
        StringBuilder ma = new StringBuilder("KH");

        for (String word : words) {
            if (!word.isEmpty()) {
                ma.append(Character.toUpperCase(word.charAt(0)));
            }
        }

        return ma.toString();
	}
	
	@GetMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteItemData(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			khoaRepository.deleteById(id);
			response.put("code", 200);
            response.put("message", "Xóa thành công!");
            response.put("redirect", "/khoa/list");
            return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("code", 500);
	        response.put("message", "Lỗi khi cập nhật người dùng: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
}
