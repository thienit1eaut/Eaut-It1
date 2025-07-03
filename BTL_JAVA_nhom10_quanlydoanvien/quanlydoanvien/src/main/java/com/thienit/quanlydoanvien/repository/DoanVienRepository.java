package com.thienit.quanlydoanvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thienit.quanlydoanvien.entity.DoanVien;
import com.thienit.quanlydoanvien.entity.User;

@Repository
public interface DoanVienRepository extends JpaRepository<DoanVien, Long> {
	// User findByUsername(String username);
	List<DoanVien> findByHotenContainingIgnoreCaseOrMadvContainingIgnoreCase(String hoten, String madv);
}
