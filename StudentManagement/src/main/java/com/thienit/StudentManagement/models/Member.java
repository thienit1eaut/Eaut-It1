package com.thienit.StudentManagement.models;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "members")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Tên không được để trống")
	private String name;
	
	private String img;
	private String lib_img;
	private String short_content;
	private String content;
	private String parent;
	
	@Email(message = "Email không hợp lệ")
	private String email;
	private String address;
	
	@Pattern(regexp = "^0[0-9]{9}$", message = "Số điện thoại không hợp lệ (phải đủ 10 số và bắt đầu bằng 0)")
	private String phone;
	
	private String position;
	private int act;
	private String create_at;
	private String update_at;
	private String gender;
	private String birthday;
	
	@NotBlank(message = "Số căn cước công dân không được để trống")
	private String cccd;
	
	private String code;

	// Constructors
    public Member() {}

    public Member(String name, String img, String lib_img, String short_content, String content, String parent, String email, String address, String phone, String position, int act, String gender, String birthday, String cccd, String code) {
    	this.name = name;
    	this.img = img;
    	this.lib_img = lib_img;
    	this.short_content = short_content;
    	this.content = content;
    	this.parent = parent;
    	this.email = email;
    	this.address = address;
    	this.phone = phone;
    	this.position = position;
    	this.act = act;
    	this.gender = gender;
    	this.birthday = birthday;
    	this.cccd = cccd;
    	this.code = code;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLib_img() {
		return lib_img;
	}
	public void setLib_img(String lib_img) {
		this.lib_img = lib_img;
	}
	public String getShort_content() {
		return short_content;
	}
	public void setShort_content(String short_content) {
		this.short_content = short_content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getAct() {
		return act;
	}
	public void setAct(int act) {
		this.act = act;
	}
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public String getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
