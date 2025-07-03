package com.thienit.quanlydoanvien.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
    private String username;
	
	private String name;
	private String password;
	private String role;
	private String parent;
	private String email;
	private int act;
	private String NOTE;
	private String create_at;
	private String update_at;
	private String matk;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
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
	
	public int getAct() {
		return act;
	}
	
	public void setAct(int act) {
		this.act = act;
	}
	
	public String getNOTE() {
		return NOTE;
	}
	
	public void setNOTE(String nOTE) {
		NOTE = nOTE;
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
	
	public String getMatk() {
		return matk;
	}

	public void setMatk(String matk) {
		this.matk = matk;
	}
	
}
