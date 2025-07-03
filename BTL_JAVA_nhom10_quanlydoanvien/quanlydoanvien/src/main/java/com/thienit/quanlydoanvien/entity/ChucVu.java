package com.thienit.quanlydoanvien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chucvu")
public class ChucVu {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String macv;
	private String tencv;
	private String note;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMacv() {
		return macv;
	}
	public void setMacv(String macv) {
		this.macv = macv;
	}
	public String getTencv() {
		return tencv;
	}
	public void setTencv(String tencv) {
		this.tencv = tencv;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
