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
import com.thienit.quanlydoanvien.entity.User;
import com.thienit.quanlydoanvien.repository.ChiDoanRepository;
import com.thienit.quanlydoanvien.repository.ChucVuRepository;
import com.thienit.quanlydoanvien.repository.DoanVienRepository;
import com.thienit.quanlydoanvien.repository.KhoaRepository;
import com.thienit.quanlydoanvien.repository.UserRepository;

@Controller
@RequestMapping("/doanvien")
public class DoanVienController {
	
	@Autowired
    private DoanVienRepository doanvienRepository;
	
	@Autowired
	private ChiDoanRepository chidoanRepository;
	
	@Autowired
	private ChucVuRepository chucvuRepository;
	
	@Autowired
	private KhoaRepository khoaRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/list")
    public String listDoanVien(Model model) {
    	model.addAttribute("doanviens", doanvienRepository.findAll());
    	return "doanvien/list";
    }
	
	@GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("doanvien", doanvienRepository.findById(id).orElse(null));
    	return "doanvien/detail";
    }
	
	@GetMapping("/search")
	public String search(@ModelAttribute("keyword") String keyword, Model model) {
	    if (keyword == null || keyword.trim().isEmpty()) {
	        model.addAttribute("doanviens", doanvienRepository.findAll());
	    } else {
	        model.addAttribute("doanviens", 
	            doanvienRepository.findByHotenContainingIgnoreCaseOrMadvContainingIgnoreCase(keyword, keyword));
	    }
	    model.addAttribute("keyword", keyword); 
	    return "doanvien/list";
	}
	
	@GetMapping("/create")
    public String registerForm(Model model) {
        model.addAttribute("doanvien", new DoanVien());
        model.addAttribute("chidoan_list", chidoanRepository.findAll());
        model.addAttribute("chucvu_list", chucvuRepository.findAll());
        model.addAttribute("khoa_list", khoaRepository.findAll());
        model.addAttribute("taikhoan_list", userRepository.findAll());
        
        return "doanvien/add";
    }
	
	@PostMapping(value = "/insert")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> saveAddForm(@ModelAttribute DoanVien doanvien, Model model) {
		Map<String, Object> response = new HashMap<>();
		try {
			String generatedCode = "DV" + doanvien.getMasv();
		    doanvien.setMadv(generatedCode);
			doanvienRepository.save(doanvien);
			response.put("code", 200);
            response.put("message", "Thêm mới thành công!");
            response.put("redirect", "/doanvien/list");
            return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("code", 500);
	        response.put("message", "Lỗi khi cập nhật người dùng: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	@GetMapping(value = "/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("doanvien", doanvienRepository.findById(id).orElse(null));
		model.addAttribute("chidoan_list", chidoanRepository.findAll());
        model.addAttribute("chucvu_list", chucvuRepository.findAll());
        model.addAttribute("khoa_list", khoaRepository.findAll());
        model.addAttribute("taikhoan_list", userRepository.findAll());
		
		return "doanvien/edit";
	}
	
	@GetMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteItemData(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			doanvienRepository.deleteById(id);
			response.put("code", 200);
            response.put("message", "Xóa thành công!");
            response.put("redirect", "/doanvien/list");
            return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("code", 500);
	        response.put("message", "Lỗi khi cập nhật người dùng: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
    }
}
